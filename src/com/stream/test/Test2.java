package com.stream.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) throws IOException {
		//读取文件内容
		String content = Files.readAllLines(Paths.get("src/1.txt"))
							  .stream()
							  .collect(Collectors.joining("\n"));
		System.out.println(content);
	}
}
