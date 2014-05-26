package com.tms.util;

import java.util.List;
import java.util.Random;

import com.tms.entity.test.Test;

/**
 * 抽取试题的简单算法
 * 
 * @author mugbya
 * 
 * @version 2014年5月12日
 * 
 */
public class TestAlgorithm {
	/**
	 * 抽取试题
	 * 
	 * @param type_test
	 *            各种类型的试题集合
	 * @param allTest
	 *            保存抽取的试题
	 * @param type_score
	 *            要抽取各种题型的分数
	 * @return
	 */
	public static void getTest(List<Test> type_test, List<Test> allTest,
			int Test_type_score) {
		Random random = new Random();

		// 准备一个与题型大小对应的boolean数组 默认全是false,表未被抽取过
		boolean[] status = new boolean[type_test.size()];
		// 抽单选
		int type_score = 0;
		while (type_score < Test_type_score) {
			// 生成随机数
			int r = random.nextInt(type_test.size());
			if (!status[r]) {
				// 如果没有被抽取过，则抽取
				status[r] = true;

				allTest.add(type_test.get(r));
				type_score += type_test.get(r).getScore();
			}
		}

		System.out.println("抽取出的各种题型分数--" + type_score);
		System.out.println("章节对应的各种题型分数--" + Test_type_score);

	}
}

// -----------------------------------------------

//
// /**
// * 简单的抽取算法
// *
// * @param test_num
// * 各种类型试题的总数
// * @param testType_score
// * 各种类型试题的总分数
// * @param type_test
// * 各种类型试题集合
// * @param testService
// * @return 返回抽取到的各种类型试题集合
// */
// public static List<Test> getTest(Integer test_num, Integer testType_score,
// List<Test> type_test, TestService testService) {
// Random r = new Random();
// int test_sum = 0;
// List<Test> testList = new ArrayList<>();
// do {
// // 以题型的总数生成随机数
// int random = r.nextInt(test_num);
//
// // 先判断抽取出来的题是否被抽取过，如果被抽过，则跳过继续抽取
// boolean status = type_test.get(random).getStatus();
//
// if (status) {
// continue;
// }
//
// // 被抽中的题取出来
// Test test = testService.findById(type_test.get(random).getId());
//
// test.setStatus(true);
//
// testService.setStatus(test);
//
// test_sum += test.getScore();
//
// // 将抽取的试题放入各种类型的集合中
// testList.add(test);
//
// } while (test_sum != testType_score);
// return testList;
// }