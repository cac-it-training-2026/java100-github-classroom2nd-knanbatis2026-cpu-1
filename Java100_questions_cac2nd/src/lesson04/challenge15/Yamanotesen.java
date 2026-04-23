package lesson04.challenge15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yamanotesen {
	public static void main(String[] args) throws IOException {
		String[] stations = { "東京",
				"新宿",
				"新橋",
				"御徒町",
				"五反田",
				"秋葉原",
				"浜松町",
				"渋谷",
				"田町",
				"恵比寿",
				"有楽町",
				"目黒",
				"大崎",
				"原宿",
				"品川",
				"目白",
				"大塚",
				"上野",
				"池袋",
				"日暮里",
				"西日暮里",
				"駒込",
				"田端",
				"高田馬場",
				"神田",
				"鴬谷",
				"代々木",
				"新大久保",
				"巣鴨",
				"高輪ゲートウェイ" };

		// 使用済みチェック配列（0：未使用、1：使用済み）
		int[] checkArray = new int[stations.length];
		for (int i = 0; i < checkArray.length; i++) {
			checkArray[i] = 0;
		}

		String inputName;
		String cpuInputName;
		int cpuIndex;

		int count = 0; // 回答回数
		boolean answerCheck = false; // 正誤判定
		boolean winFlag = true; // 勝敗判定

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("※※※ 山手線ゲーム ※※※");
		System.out.println();

		System.out.println("      ゲームスタート！    ");
		System.out.println();

		// ゲーム部分
		while (count < checkArray.length) {

			// プレイヤーの操作
			inputName = br.readLine();

			// 入力値のチェック
			for (int i = 0; i < checkArray.length; i++) {
				if (stations[i].equals(inputName) && checkArray[i] == 0) {
					checkArray[i] = 1;
					count++;
					answerCheck = true;
					break;
				}
			}
			// 正誤判定
			if (!answerCheck) {
				winFlag = false;
				break;
			}
			answerCheck = false;

			// プレイヤーの手番後に終了判定
			if (count >= checkArray.length) {
				break;
			}

			// CPUの操作
			while (true) {
				cpuIndex = (int) (Math.random() * checkArray.length);
				if (checkArray[cpuIndex] == 0) {
					System.out.println(stations[cpuIndex]);
					checkArray[cpuIndex] = 1;
					count++;
					break;
				}
			}
		}

		// 勝敗判定
		if (winFlag) {
			System.out.println("あなたの勝ちです");
		} else {
			System.out.println("あなたの負けです。");
		}

	}
}
