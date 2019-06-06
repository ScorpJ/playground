package com.artur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MoveFiles {
	
	
	private static final String root = "D:\\MyDocs\\Egnlish\\English Pod";

	
	
	
	public void moveFileRecurise(Path root, Path destRoot){
		
		
		System.out.println("Process "+root.toString());
		
		File[] subs = root.toFile().listFiles((File pathname) -> {
			return pathname.isDirectory()||pathname.getName().endsWith("mp3")||pathname.getName().endsWith("pdf");
		});
		
		System.out.println("Subs length: "+ subs.length);
		
		
		for(File sub:subs){
			if(sub.isDirectory()){
				moveFileRecurise(sub.toPath(), destRoot);
			}else{
				
				System.out.println("Copying  "+ sub.getName());
				try(FileChannel destChannel =
						FileChannel.open(Paths.get(destRoot.toString(), sub.getName()), 
								StandardOpenOption.WRITE,StandardOpenOption.CREATE);
						ReadableByteChannel srcChannels = Channels.newChannel(new FileInputStream(sub))) {
				
					destChannel.transferFrom(srcChannels, 0, Integer.MAX_VALUE);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveFiles client = new MoveFiles();
		client.moveFileRecurise(Paths.get(root), Paths.get(root));
	}

}
