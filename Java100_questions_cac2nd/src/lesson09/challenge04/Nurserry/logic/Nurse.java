package lesson09.challenge04.Nurserry.logic;

import lesson14.challenge04.Nurserry.Exception.CriticalConditionException;

public class Nurse {
	private String name;

	public Nurse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//ここに適切な処理を記述
	public void takeTemperature(NurserySchoolChild child) throws CriticalConditionException {
		System.out.println();
		if (child.getTemperature() >= 38) {
			//new CriticalConditionException(child);
			throw new CriticalConditionException(child);
		} else {
			System.out.println(child.getName() + "の体温は" + child.getTemperature() + "度です。");
		}
	}

}
