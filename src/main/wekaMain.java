//package main;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Random;
//
//import weka.classifiers.Classifier;
//import weka.classifiers.Evaluation;
//import weka.core.Instance;
//import weka.core.Instances;
//import weka.core.converters.ArffLoader;
//import writeAndRead.WriteLine;
//
//public class wekaMain {
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		Classifier classifier1;
//		// Classifier classifier2;
//		// Classifier classifier3;
//		// Classifier classifier4;
//
//		System.out.println("开始加载数据！");
//		File inpFile = new File("processData\\test0.arff");
//		ArffLoader arf = new ArffLoader();
//		arf.setFile(inpFile);
//		Instances instancesTrain = arf.getDataSet();
//		System.out.println("加载train数据完毕！");
//		instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
//
//		// navie bays
//		// classifier1 = (Classifier) Class.forName(
//		// "weka.classifiers.bayes.NaiveBayes").newInstance();
//		// classifier1.buildClassifier(instancesTrain);
//		// System.out.println("navie bays is ok!");
//		// // 鍐崇瓥鏍�
//		// classifier2 = (Classifier)
//		// Class.forName("weka.classifiers.trees.J48")
//		// .newInstance();
//		// classifier2.buildClassifier(instancesTrain);
//		// System.out.println("鍐崇瓥鏍�is ok!");
//		// Zero
//		// classifier3 = (Classifier) Class.forName(
//		// "weka.classifiers.rules.ZeroR").newInstance();
//		// classifier3.buildClassifier(instancesTrain);
//		// System.out.println("Zero is ok!");
//		// LibSVM
//		// classifier4 = (Classifier) Class.forName(
//		// "weka.classifiers.functions.LibSVM").newInstance();
//		// classifier4.buildClassifier(instancesTrain);
//		// System.out.println("LibSVM is ok!");
//		// RandomForest
//
//		System.out.println("开始构造分类器");
//		classifier1 = (Classifier) Class.forName(
//				"weka.classifiers.trees.RandomForest").newInstance();
//		classifier1.buildClassifier(instancesTrain);
//		System.out.println("RandomForest Model is ok!");
//
////		System.out.println("Result is writing!");
////		WriteLine writer = new WriteLine("dataProcess\\class.utf8");
////		inpFile = new File("dataProcess\\test_data_nopre_20w.arff");
////		arf.setFile(inpFile);
////		Instances instancesTest = arf.getDataSet();
////		instancesTest.setClassIndex(instancesTest.numAttributes() - 1);
////		int sum = instancesTest.numInstances();
////		for (int i = 0; i < sum; i++) {
////			int type = (int) classfiers1.classifyInstance(instancesTest
////					.instance(i));
////			writer.appendLine(type);
////		}
//
//		// 娴嬭瘯闆嗛獙璇�
//		// Evaluation eval = new Evaluation(instancesTrain);
//
//		// eval.evaluateModel(classifiWer1, instancesTest);
//		// System.out.println(eval.errorRate());
//		//
//		// eval.evaluateModel(classifier2, instancesTest);
//		// System.out.println(eval.errorRate());
//		//
//		// eval.evaluateModel(classifier3, instancesTest);
//		// System.out.println(eval.errorRate());
//
//		// eval.evaluateModel(classifier4, instancesTest);
//		// System.out.println(eval.errorRate());
//		//
//		// eva2.crossValidateModel(classifier3, instancesTrain, 10, new
//		// Random(1));
//		// System.out.println(eva2.errorRate());
//		//
//		// eva2.crossValidateModel(classifier4, instancesTrain, 10, new
//		// Random(1));
//		// System.out.println(eva2.errorRate());
//
//		// 交叉验证
//		 System.out.println("开始交叉验证2");
//		 Evaluation eva1 = new Evaluation(instancesTrain);
//		 eva1.crossValidateModel(classifier1, instancesTrain, 3, new
//		 Random(1));
//		 System.out.println(eva1.errorRate());
//		 System.out.println(eva1.recall(1));
//		 System.out.println(eva1.recall(0));
//		 System.out.println("交叉验证完毕2！");
//	}
//
//}
