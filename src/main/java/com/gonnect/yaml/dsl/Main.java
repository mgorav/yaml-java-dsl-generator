package com.gonnect.yaml.dsl;

import java.io.File;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		// Make sure there is exactly one command line argument, the path to the YAML file
//		if (args.length != 1) {
//			System.out.println("Please supply exactly one argument, the absolute path of the YAML file.");
//			return;
//		}
		
		// Get the YAML file's handle, and the directory it's contained in
		// (generated files will be placed there)
		final String yamlFilePath = "/Users/gmalho/Documents/Personal/MyGitHub/yaml-java-dsl/src/main/java/com/gonnect/yaml/dsl/dummy.yaml";// args[0];
		final File yamlFile = new File(yamlFilePath);
		final File outputDirectory = yamlFile.getParentFile();

		// Step 1: Read in the YAML file, into class specifications
		YamlClassSpecificationReader yamlReader = new YamlClassSpecificationReader();
		List<ClassSpecification> classSpecifications = yamlReader.read(yamlFile);

		// Step 2: Generate Java source files from the class specifications
		JavaDataClassGenerator javaDataClassGenerator = new JavaDataClassGenerator();
		javaDataClassGenerator.generateJavaSourceFiles(classSpecifications, outputDirectory);

		System.out.println("Successfully generated files to: " + outputDirectory.getAbsolutePath());
	}
}
