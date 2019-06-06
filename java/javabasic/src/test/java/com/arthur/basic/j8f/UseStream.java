package com.arthur.basic.j8f;


import org.apache.logging.log4j.util.Strings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UseStream {

    private int counter;

    @Before
    public void setUp() {
        this.counter = 0;
    }

    @After
    public void tearDown() {
    }

    private void addCounter(){
        counter++;
    }



    /**
     * Stream creation related start
     * 1. Stream.empty();
     * 2. Collection::stream()  [list.stream(), set.stream()]
     * 3. Stream of Array: Stream.of(t1, t2, t3)  [Stream.of(T... t)]
     * 4. Stream.builder()
     * 5. Stream.generate(): use as Supplier
     *      Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
     * 6. Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
     * 7. IntStream, LongStream, DoubleStream, range(), rangeClose
     * 8. Stream<String> streamOfString =
     *         Pattern.compile(", ").splitAsStream("a, b, c");
     * 9. Stream<String> streamWithCharset =
     *         Files.lines(path, Charset.forName("UTF-8"));
     * 10. StreamSupport
     * */
    @Test
    public void createStreamFromArray(){
        Stream<String> stream = Stream.of("abc1", "abc2", "abc3");
        long c = stream.filter(element -> element.contains("2")).count();
        assertThat(c).isEqualTo(1);
    }

    @Test
    public void createStreamByBuilder(){
        Stream<String> stream = Stream.<String>builder().add("abc1").add("abc2").add("abc3").build();
        long c = stream.filter(element -> element.contains("2")).count();
        assertThat(c).isEqualTo(1);
    }

    @Test
    public void createStreamBySpliterator(){

        Spliterator<String> mySpliterator = new Spliterator<String>() {
            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return 0;
            }

            @Override
            public int characteristics() {
                return 0;
            }
        };


        StreamSupport.stream(mySpliterator, false);

    }



    /* Stream creation related end*/

    @Test(expected = IllegalStateException.class)
    public void streamReference(){
        Stream<String> stream = Stream.<String>builder().add("abc1").add("abc2").add("abc3").build();
        stream.count();
        stream.collect(Collectors.toList());
    }


    /**
     * Intermediate operations are lazy.
     * This means that they will be invoked only if it is necessary for the terminal operation execution.
     */
    @Test
    public void lazeIntermediateOperation(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> stream = list.stream().filter(element -> {
            addCounter();
            return element.contains("2");
        });

        assertThat(counter).isEqualTo(0);
        stream.count();
        assertThat(counter).isEqualTo(3);
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void optionalResultOfStreamOperation(){
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        list.stream().filter(ele -> ele.contains("5")).findFirst().get();
    }

    /* Stream operation related start  */
    /**
     *  1. flatMap
     *  2. map
     *  3. peek
     */

    @Test
    public void flatMap(){
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        List<String> filteredList = listOfOptionals.stream()
                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
                .collect(Collectors.toList());

        assertThat(filteredList).hasSize(2)
                                .contains("foo", "bar");
    }

    @Test
    public void map(){
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        List<String> filteredList = listOfOptionals.stream()
                .filter(o -> o.isPresent())
                .map(o -> o.orElse(Strings.EMPTY))
                .collect(Collectors.toList());

        assertThat(filteredList).hasSize(2)
                .contains("foo", "bar");

    }

    /**
     * Stream is a sequence of operations performed on elements, one by one.
     */
    @Test
    public void testPeek(){

        List<String> list = Arrays.asList("abc1", "abc2", "abc3", "def");

        list.stream().peek(e -> System.out.println("Before map:" + e))
                .filter(e -> e.contains("abc"))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("After map:" + e))
                .forEach(e -> System.out.println("Foreach:"+ e));


    }


    /* Collector related start*/
    /**
     * Collector is used as the final step of steam processing
     * java.util.stream.Collectors contains predefined implementations
     * 1. toList
     * 2. toSet
     * 3. toCollection, pass in a collection implementation constructor reference
     *         stream.collect(Collectors.toCollection(LinkedList::new));
     * 4. toMap(Function)
     * 5. statistic
     * 6. Custom Collectors
     */


    @Test
    public void collectStream2List(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim","T1", "T2", "T3");

        List<String> list = stream.filter(name -> name.startsWith("T"))
                .filter(name -> name.contains("T"))
                .collect(Collectors.toList());

        assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void collectStream2Set(){

        Stream<String> stream = Stream.of("Tom", "Mike", "Jim","T1", "T1", "T1");

        Set<String> set = stream.filter(name -> name.startsWith("T"))
                .filter(name -> name.contains("T"))
                .collect(Collectors.toSet());

        assertThat(set.size()).isEqualTo(2);

    }

    @Test
    public void collectStream2Collection(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim","T1", "T1", "T1");
        List<String> list = stream.collect(Collectors.toCollection(LinkedList::new));
        assertThat(list).hasSize(6);

        Stream<String> stream2 = Stream.of("Tom", "Mike", "Jim","T1", "T1", "T1");
        Set<String> set = stream2.collect(Collectors.toCollection(HashSet::new));
        assertThat(set).hasSize(4);
    }

    @Test
    public void collectStream2Map(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");

        Map<String, Integer> nameLenMap = stream.collect(Collectors.toMap(name -> name, name -> name.length()));

        assertThat(nameLenMap).containsKeys("Tom", "Mike", "Jim");

    }

    @Test
    public void collectStream2MapWithMergeFunction(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");

        Map<Integer, List<String>> map =
                stream.collect(Collectors.toMap(name -> Integer.valueOf(name.length()),
                                                name -> { List<String> l = new ArrayList<>();
                                                          l.add(name);
                                                          return l;},
                                                (list1, list2) -> {
                                                    list1.addAll(list2);
                                                    return list1;
                } ));

        assertThat(map).containsKeys(3,4);
        assertThat(map.get(3)).contains("Tom","Jim");
        assertThat(map.get(4)).containsOnly("Mike");
    }

    @Test
    public void collectStreamByJoining(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");
        String rt = stream.collect(Collectors.joining("-","<",">"));
        assertThat(rt).isEqualTo("<Tom-Mike-Jim>");
    }


    @Test
    public void summarizingInt(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim", "Arthur","Abby");
        IntSummaryStatistics iss = stream.collect(Collectors.summarizingInt(String::length));
        assertThat(iss.getCount()).isEqualTo(5);
        assertThat(iss.getMin()).isEqualTo(3);
        assertThat(iss.getMax()).isEqualTo(6);
    }


    @Test
    public void summarizingDouble(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim", "Arthur","Abby");
        DoubleSummaryStatistics dss = stream.collect(Collectors.summarizingDouble(String::length));
        assertThat(dss.getCount()).isEqualTo(5);
        assertThat(dss.getMin()).isEqualTo(3);
        assertThat(dss.getMax()).isEqualTo(6);
    }

    @Test
    public void groupingBy(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");
        Map<Integer, List<String>> map =
                stream.collect(Collectors.groupingBy(String::length));

        assertThat(map).containsKeys(3,4);
        assertThat(map.get(3)).contains("Tom","Jim");
        assertThat(map.get(4)).containsOnly("Mike");

    }


    @Test
    public void customCollector(){
        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");

        Collector<String, StringBuilder, String> myCollector = new Collector<String, StringBuilder, String>(){


            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, String> accumulator() {
                return (first,second) -> first.append(second.toUpperCase());
            }


            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return StringBuilder::append;
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return StringBuilder::toString;
            }

            @Override
            public Set<Characteristics> characteristics() {
                List l = Arrays.asList(Characteristics.UNORDERED);
                return new HashSet(l);
            }
        };

        String rt = stream.collect(myCollector);

        assertThat(rt).isEqualTo("TOMMIKEJIM");
    }

    @Test
    public void customCollectorByOf(){

        Stream<String> stream = Stream.of("Tom", "Mike", "Jim");

        Collector<String, StringBuilder, String> myCollector =
                Collector.of(StringBuilder::new,
                             (first,second) -> first.append(second.toUpperCase()),
                             StringBuilder::append,
                             StringBuilder::toString,
                             Collector.Characteristics.UNORDERED
                             );

        String rt = stream.collect(myCollector);

        assertThat(rt).isEqualTo("TOMMIKEJIM");


    }



    /* Collector related end*/
}
