package com.arthur.basic;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WildTest {


    public static void main(String[] args){
//        String s = "{\n" +
//                "  \\\"ProfileId\\\" : 300100169303437,\n" +
//                "  \\\"PscUserId\\\" : 300100169285292,\n" +
//                "  \\\"ProfileStatus\\\" : \\\"A\\\",\n" +
//                "  \\\"ProfileName\\\" : \\\"Test2\\\",\n" +
//                "  \\\"BusinessName\\\" : \\\"Test2\\\",\n" +
//                "  \\\"BusinessType\\\" : null,\n" +
//                "  \\\"IsContractor\\\" : \\\"N\\\",\n" +
//                "  \\\"CntrctrVerificationStatus\\\" : null,\n" +
//                "  \\\"links\\\" : [ {\n" +
//                "    \\\"rel\\\" : \\\"self\\\",\n" +
//                "    \\\"href\\\" : \\\"https://fuscdrmsmc295-fa-ext.us.oracle.com:443/fscmRestApi/resources/11.13.18.05/publicSectorBusinessProfiles/300100169303437\\\",\n" +
//                "    \\\"name\\\" : \\\"publicSectorBusinessProfiles\\\",\n" +
//                "    \\\"kind\\\" : \\\"item\\\",\n" +
//                "    \\\"properties\\\" : {\n" +
//                "      \\\"changeIndicator\\\" : \\\"ACED0005737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000178\\\"\n" +
//                "    }\n" +
//                "  }, {\n" +
//                "    \\\"rel\\\" : \\\"canonical\\\",\n" +
//                "    \\\"href\\\" : \\\"https://fuscdrmsmc295-fa-ext.us.oracle.com:443/fscmRestApi/resources/11.13.18.05/publicSectorBusinessProfiles/300100169303437\\\",\n" +
//                "    \\\"name\\\" : \\\"publicSectorBusinessProfiles\\\",\n" +
//                "    \\\"kind\\\" : \\\"item\\\"\n" +
//                "  }, {\n" +
//                "    \\\"rel\\\" : \\\"child\\\",\n" +
//                "    \\\"href\\\" : \\\"https://fuscdrmsmc295-fa-ext.us.oracle.com:443/fscmRestApi/resources/11.13.18.05/publicSectorBusinessProfiles/300100169303437/child/ProfileContactPointPhone\\\",\n" +
//                "    \\\"name\\\" : \\\"ProfileContactPointPhone\\\",\n" +
//                "    \\\"kind\\\" : \\\"collection\\\"\n" +
//                "  }, {\n" +
//                "    \\\"rel\\\" : \\\"child\\\",\n" +
//                "    \\\"href\\\" : \\\"https://fuscdrmsmc295-fa-ext.us.oracle.com:443/fscmRestApi/resources/11.13.18.05/publicSectorBusinessProfiles/300100169303437/child/ProfileLocation\\\",\n" +
//                "    \\\"name\\\" : \\\"ProfileLocation\\\",\n" +
//                "    \\\"kind\\\" : \\\"collection\\\"\n" +
//                "  }, {\n" +
//                "    \\\"rel\\\" : \\\"child\\\",\n" +
//                "    \\\"href\\\" : \\\"https://fuscdrmsmc295-fa-ext.us.oracle.com:443/fscmRestApi/resources/11.13.18.05/publicSectorBusinessProfiles/300100169303437/child/ProfileContactPointEmail\\\",\n" +
//                "    \\\"name\\\" : \\\"ProfileContactPointEmail\\\",\n" +
//                "    \\\"kind\\\" : \\\"collection\\\"\n" +
//                "  } ]\n" +
//                "}";


                 List<Object> inputList = new ArrayList<>();
                 String str = "MMVI";

//                 str.chars().collect(Collectors.toList());


                str.chars().forEach(val -> {
                    String symbol = String.valueOf((char)val);
                    inputList.add(symbol);
                });

        System.out.println(inputList);



    }








}
