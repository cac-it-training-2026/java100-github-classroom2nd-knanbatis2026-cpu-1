package lesson14.challenge04.Nurserry.Exception;

import lesson09.challenge04.Nurserry.logic.NurserySchoolChild;

public class CriticalConditionException extends Exception {
	public CriticalConditionException(NurserySchoolChild child) {
		super("38度以上です。");
		System.out.println(child.getName() + "は重体です。");
		System.out.println();
		System.out.println("すぐに病院に行ってください。");
	}
}
