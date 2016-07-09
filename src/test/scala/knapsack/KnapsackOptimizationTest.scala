package knapsack

import org.scalatest.WordSpec
import org.scalatest.ShouldMatchers

class KnapsackOptimizationTest extends WordSpec with ShouldMatchers {
  val optimization: KnapsackOptimization = KnapsackOptimization(10)

  "Knapsack optimization" should {
    "select nothing when empty elements provided" in {
      val elements: Map[Int, Int] = Map()

      val selected: Map[Int, Int] = optimization.select(elements)

      selected shouldBe empty
    }

    "select nothing when no element fits into knapsack" in {
      val elements: Map[Int, Int] = Map((11, 1), (12, 1))

      val selected: Map[Int, Int] = optimization.select(elements)

      selected shouldBe empty
    }

    "select all elements if they all fit in the knapsack" in {
      val elements: Map[Int, Int] = Map((5, 3), (1, 3), (4, 6))

      val selected: Map[Int, Int] = optimization.select(elements)

      selected should contain only ((5, 3), (1, 3), (4, 6))
    }

    "select the subset of elements which maximize the provided condition" in {
      val elements: Map[Int, Int] = Map((5, 3), (1, 3), (2, 2), (6, 4), (4, 6))

      val selected: Map[Int, Int] = optimization.select(elements)

      selected should contain only ((5, 3), (1, 3), (4, 6))
    }

    "select any candidates which fit into knapsack from lots of elements" in {
      val elements: Map[Int, Int] = (1 to 15).map(a => (a, a)).toMap

      val selected: Map[Int, Int] = optimization.select(elements)

      selected.keys.sum shouldBe 10
      selected.values.sum shouldBe 10
    }
  }
}
