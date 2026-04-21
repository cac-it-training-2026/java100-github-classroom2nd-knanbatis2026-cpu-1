/**
 * 第4章 倉庫番のお仕事
 *
 * 問題8 荷物の入れ替え（二つの配列の要素を入れ替える）
 *
 * AB興産から新たな荷物のセットを預かりました。
 * 5袋からなる荷物のセットで、それぞれ6～10の数値が入っており、
 * どの袋にどの数値が入っているのかはランダムに決定し、
 * それぞれの袋の値は重複しません。
 *
 * AB興産からの依頼は、以前から預かっている1～5の荷物と
 * 今回預かる6～10の荷物を再編し、奇数のみの配列と
 * 偶数のみの配列に分けるというものです。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  AB興産から新たに預かった荷物と以前から預かっている荷物の
 *  中身を確認してください。
 *
 *  Yさん：
 *  はい、
 *  以前から預かっている荷物の状態は、
 *  3,2,1,5,4
 *  です。
 *
 *  今回預かった荷物の状態は、
 *  7,9,10,6,8
 *  です。
 *
 *  E主任：
 *  その二つの荷物を奇数群、偶数群で入れ替えてください。
 *
 *  Yさん：
 *  はい、入れ替えました。
 *  奇数群の荷物の状態は、
 *  3,5,1,9,7
 *  です。
 *
 *  偶数群の荷物の状態は、
 *  10,2,8,6,4
 *  です。
 *
 */

package lesson04.challenge08;

public class WarehouseManager {

	public static void main(String[] args) {

		int[] ABKosanArray1 = new int[5];
		int[] ABKosanArray2 = new int[5];

		//ここに重複チェックおよび値の代入処理を記述する①(1～5)
		ABKosanArray1 = initArray(ABKosanArray1.length, 1, 5);

		//ここに重複チェックおよび値の代入処理を記述する②(6～10)
		ABKosanArray2 = initArray(ABKosanArray2.length, 6, 10);

		System.out.println("E主任：");
		System.out.println("AB興産から新たに預かった荷物と以前から預かっている荷物の");
		System.out.println("中身を確認してください。\n");

		System.out.println("Yさん：");
		System.out.println("はい、");
		System.out.println("以前から預かっている荷物の状態は、");
		for (int i = 0; i < ABKosanArray1.length; i++) {
			System.out.print(ABKosanArray1[i]);
			if (i != (ABKosanArray1.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("今回預かった荷物の状態は、");
		for (int i = 0; i < ABKosanArray2.length; i++) {
			System.out.print(ABKosanArray2[i]);
			if (i != (ABKosanArray2.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("E主任：");
		System.out.println("その二つの荷物を奇数群、偶数群で入れ替えてください。\n");

		//ここに奇数群(ABKosanArray1)と偶数群(ABKosanArray2)に振り分ける処理を記述する。

		// 一旦tmp配列にすべていれる
		int[] tmpArray = new int[ABKosanArray1.length + ABKosanArray2.length];
		for (int i = 0; i < ABKosanArray1.length; i++) {
			tmpArray[i] = ABKosanArray1[i];
		}
		for (int i = 0; i < ABKosanArray2.length; i++) {
			tmpArray[i + ABKosanArray1.length] = ABKosanArray2[i];
		}

		int count1 = 0;
		int count2 = 0;

		// 振り分け
		for (int i : tmpArray) {
			if (i % 2 == 1) {
				ABKosanArray1[count1] = i;
				count1++;
			} else {
				ABKosanArray2[count2] = i;
				count2++;
			}
		}

		System.out.println("Yさん：");
		System.out.println("はい、入れ替えました。");
		System.out.println("奇数群の荷物の状態は、");
		for (int i = 0; i < ABKosanArray1.length; i++) {
			System.out.print(ABKosanArray1[i]);
			if (i != (ABKosanArray1.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		System.out.println("偶数群の荷物の状態は、");
		System.out.println("");
		for (int i = 0; i < ABKosanArray2.length; i++) {
			System.out.print(ABKosanArray2[i]);
			if (i != (ABKosanArray2.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。");

	}

	/**
	 * 配列に重複無しでx~yの間の値を、arraylength個入れる
	 * @param arraylength
	 * @param x
	 * @param y
	 * @return
	 */
	public static int[] initArray(int arraylength, int x, int y) {
		int intputNum = 0;
		boolean loopFlag = false;
		int[] intArray = new int[arraylength];
		if (y - x > arraylength) {
			System.err.println("誤った引数");
			return intArray;
		}

		//ここに重複チェックおよび値の代入処理を記述
		for (int i = 0; i < intArray.length; i++) {
			intputNum = (int) (Math.random() * (y - x + 1)) + x;
			for (int j : intArray) {
				if (j == intputNum) {
					loopFlag = true;
					break;
				}
			}
			if (loopFlag) {
				loopFlag = false;
				i--;
				continue;
			}
			intArray[i] = intputNum;
		}
		return intArray;
	}
}
