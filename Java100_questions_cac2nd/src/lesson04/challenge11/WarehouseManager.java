/**
 * 第4章 倉庫番のお仕事
 *
 * 問題11 荷物の入れ替え（三つの配列をまとめる）
 *
 * MQ運送から、新たに三つのコンテナ群を預かり
 * 委託管理を行うことになりました。
 * 三つのコンテナ群はそれぞれ5箱ずつからなり、
 * 合計すると15箱の入れ物になります。
 *
 * 併せてMQ運送から依頼があり、
 * コンテナ群のうち空き箱がいくつかあるので、
 * 空いてるところは詰めてほしいと言われました。
 * つまり、
 *
 * 有、空、有、空、有
 *
 * と並んでいた場合は、
 *
 * 有、有、有、空、空
 *
 * としてほしいという依頼です。
 *
 * 各コンテナのどの箱が空き箱なのかはランダムに決定し、
 * 空き箱である確率は1/4です。
 * 中身がある箱には1～10の何れかの数値が入り、
 * これもランダムに決定します。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  MQ運送の件、お願いします。
 *
 *  Yさん：
 *  はい、まずは現状から確認いたします。
 *
 *  C...3,4,4,0,7
 *
 *  D...0,5,0,9,0
 *
 *  E...2,1,3,10,6
 *
 *  でした。直してきます...
 *
 *  Yさん：
 *  直してきました。
 *
 *  C...3,4,4,7,5
 *
 *  D...9,2,1,3,10
 *
 *  E...6,0,0,0,0
 *
 *  になりました。
 *
 *  E主任：
 *  ご苦労さまでした。
 *
 */

package lesson04.challenge11;

public class WarehouseManager {

	public static void main(String[] args) {

		//ここに必要な配列の宣言を記述する。
		int[] intArray1 = new int[5];
		int[] intArray2 = new int[5];
		int[] intArray3 = new int[5];

		//ここに配列に値を代入する処理を記述する。(要素はランダム)
		intArray1 = pushNumber(intArray1.length);
		intArray2 = pushNumber(intArray2.length);
		intArray3 = pushNumber(intArray3.length);

		System.out.println("E主任：");
		System.out.println("MQ運送の件、お願いします。\n");

		System.out.println("Yさん：");
		System.out.println("はい、まずは現状から確認いたします。\n");

		System.out.print("C...");

		//ここに配列Cの要素をすべて出力する処理を記述する。
		printArray(intArray1);

		System.out.print("\n\nD...");

		//ここに配列Dの要素をすべて出力する処理を記述する。
		printArray(intArray2);

		System.out.print("\n\nE...");

		//ここに配列Eの要素をすべて出力する処理を記述する。
		printArray(intArray3);

		System.out.println("\n\nでした。直してきます...\n");

		//ここに詰め替え処理を記述する
		int[] tmpArray = new int[15];

		for (int i = 0; i < tmpArray.length; i++) {
			switch (i / 5) {
			case 0:
				tmpArray[i] = intArray1[i];
				break;
			case 1:
				tmpArray[i] = intArray2[i % 5];
				break;
			case 2:
				tmpArray[i] = intArray3[i % 5];
				break;
			}
		}
		for (int i : tmpArray) {
			System.out.println(i);
		}

		System.out.println("Yさん：");
		System.out.println("直してきました。\n");

		System.out.print("C...");

		//ここに配列Cの要素をすべて出力する処理を記述する。

		System.out.print("\n\nD...");

		//ここに配列Dの要素をすべて出力する処理を記述する。

		System.out.print("\n\nE...");

		//ここに配列Eの要素をすべて出力する処理を記述する。

		System.out.println("\n\nになりました。\n");

		System.out.println("E主任：");
		System.out.println("ご苦労さまでした。");
	}

	// 配列の中身を表示する
	public static void printArray(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]);
			if (i < intArray.length - 1) {
				System.out.print(",");
			}
		}
	}

	// 配列に1~10の値を入れる。1/4の確率で0を入れる。
	public static int[] pushNumber(int arrayLength) {
		int[] intArray = new int[arrayLength];
		int emptyBox;
		int randomNum;

		for (int i = 0; i < intArray.length; i++) {
			emptyBox = (int) (Math.random() * 4);
			randomNum = (int) (Math.random() * 10) + 1;
			if (emptyBox == 0) {
				intArray[i] = 0;
			} else {
				intArray[i] = randomNum;
			}
		}
		return intArray;
	}

}
