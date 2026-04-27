package lesson05.challenge10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 丼を作成するロボット
 *  
 *  
 * 食材の数を入力し、どんぶりを作成する
 * ご飯が足りない場合、作る個数を入力する
 * 
 * ・丼一杯に必要な素材
 * ご飯1合
 * +
 * 牛肉100g
 * 海鮮100g
 * 天ぷら4個
 * 
 * 
 *
 */

public class SuperRobot {
	Food rice = new Food("白ご飯", "ご飯", 0, "合", 1);
	Food beef = new Food("牛丼", "牛肉", 0, "グラム", 100);
	Food seafood = new Food("海鮮丼", "海鮮", 0, "グラム", 100);
	Food tenpura = new Food("天丼", "天ぷら", 0, "個", 4);

	Food[] foodSet = { rice, beef, seafood, tenpura };

	/**
	 * 素材の数をsetする
	 * @throws IOException
	 */
	public void setFoods() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (Food food : foodSet) {
			System.out.print("使用する" + food.material + "の量を入力してください。（" + food.tanni + "）＞");
			food.quantity = Integer.parseInt(br.readLine());
		}
		System.out.println();
	}

	public void showFoods() {
		for (Food food : foodSet) {
			System.out.println(food.material + "\t：\t" + food.quantity + "\t（" + food.tanni + "）");
		}
		System.out.println();
	}

	/**
	 * 丼を作る
	 * @throws IOException
	 */
	public void makeDonburi() throws IOException {
		/**
		 * どんぶりを作成可能な量
		 */
		int[] bowlCounts = new int[4];
		/**
		 * 作る丼の数
		 */
		int[] bowls = { 0, 0, 0, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("どんぶりを作ります。");
		System.out.println("--------------------");
		System.out.println();

		System.out.println("---具材一覧---");
		this.showFoods();

		this.setFoods();

		for (int i = 0; i < bowlCounts.length; i++) {
			bowlCounts[i] = (int) (foodSet[i].quantity / foodSet[i].needQuantity);
		}

		System.out.println("計" + bowlCounts[0] + "杯のどんぶりを作れます。");
		System.out.println();

		for (int i = 1; i < foodSet.length; i++) {
			System.out.println(bowlCounts[i] + "杯の" + foodSet[i].name + "を作れます。");
		}
		System.out.println();

		while (true) {
			if (bowlCounts[0] - (bowlCounts[1] + bowlCounts[2] + bowlCounts[3]) > 0) {
				for (int i = 1; i < foodSet.length; i++) {
					bowls[i] = bowlCounts[i];
				}
				break;
			} else {
				System.out.println("ご飯が足りません。");
				System.out.println();
				System.out.println("合計" + bowlCounts[0] + "杯になるように作る個数を決めてください。");

				for (int i = 1; i < bowlCounts.length; i++) {
					System.out.print(foodSet[i].name + "を作る数（" + bowlCounts[i] + "杯以内）＞");
					bowls[i] = Integer.parseInt(br.readLine());
					if (bowlCounts[i] < bowls[i] || bowls[i] < 0) {
						System.out.println();
						System.out.println("0杯以上" + bowlCounts[i] + "杯以内を入力してください。");
						System.out.println();
						i--;
						continue;
					}
				}
				System.out.println();
				break;
			}
		}
		for (int i = 1; i < foodSet.length; i++) {
			System.out.println(foodSet[i].name + "を" + bowls[i] + "杯作りました。");
			foodSet[i].quantity -= foodSet[i].needQuantity * bowls[i];
		}
		rice.quantity -= (bowls[1] + bowls[2] + bowls[3]);

		System.out.println();
		System.out.println("---余った食料------");
		showFoods();
	}

	/**
	 * Foodクラス
	 * どんぶりに必要な食材のデータをいれる
	 */
	class Food {
		/**
		 * どんぶりの名前
		 */
		private String name;
		/**
		 * 素材
		 */
		private String material;
		/**
		 * 現在の量
		 */
		private int quantity;
		/**
		 * 単位
		 */
		private String tanni;
		/**
		 * どんぶり一杯に必要な量
		 */
		private int needQuantity;

		/**
		 * @param name
		 * @param material
		 * @param quantity
		 * @param tanni
		 * @param needQuantity
		 */
		public Food(String name, String material, int quantity, String tanni, int needQuantity) {
			this.name = name;
			this.material = material;
			this.quantity = quantity;
			this.tanni = tanni;
			this.needQuantity = needQuantity;
		}

	}
}
