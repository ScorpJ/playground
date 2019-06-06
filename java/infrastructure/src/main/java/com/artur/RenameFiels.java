package com.artur;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class RenameFiels {

	
	private static final String root = "D:\\MyDocs\\Egnlish\\English Pod";
    private Pattern p = Pattern.compile("([BCDEF])[\\d]{4}");
	
	
	public void renameFiles(Path root){
		
		
		File[] audioFiles = root.toFile().listFiles((File pathname) -> {
			return pathname.getName().endsWith("mp3");
		});
		
		
		for(File audioFile:audioFiles){			
			processRename(audioFile);			
		}
		
		
	}
	
	
	private void processRename(File targetFile){
		String fullFileName = targetFile.getName();	
		System.out.println("Process file:"+fullFileName);
		Matcher m = p.matcher(fullFileName);
		if(m.find()){
			String level = m.group(1);
			
			int idx = fullFileName.indexOf(".");
			String fileName = fullFileName.substring(0,idx);
			String exten = fullFileName.substring(idx);
			
			String destName = fileName.replaceAll(level, "") + "_"+level+exten;			
			System.out.println("Rename file from "+ fullFileName + " to "+destName);			
			targetFile.renameTo(new File(targetFile.getParentFile(),destName));
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RenameFiels rf = new RenameFiels();		
//		File targetFile = new File("D:\\MyDocs\\Egnlish\\English Pod","englishpod_B0017dg.mp3");		
//		rf.processRename(targetFile);
		
		
		rf.renameFiles(Paths.get(root, "Part4_181-240"));
		
		JSONObject j ;
	}

}
