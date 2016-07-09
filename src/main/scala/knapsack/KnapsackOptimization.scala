package knapsack

import scala.collection.mutable

case class KnapsackOptimization(capacity: Int) {

  def select(elements: Map[Int, Int]): Map[Int, Int] = {
    selectWithCache(elements, mutable.Map.empty[Map[Int, Int], Map[Int, Int]])
  }

  private def selectWithCache(
    elements: Map[Int, Int],
    cachedSelections: mutable.Map[Map[Int, Int], Map[Int, Int]]): Map[Int, Int] = {

    if (elements.keys.sum <= capacity) {
      elements
    }
    else {
      var best = Map.empty[Int, Int]
      for {
        element <- elements
        subset: Map[Int, Int] = elements - element._1
      } {
        if (!cachedSelections.contains(subset))
          cachedSelections.update(subset, selectWithCache(subset, cachedSelections))

        val candidate = cachedSelections(subset)

        if (candidate.values.sum > best.values.sum)
          best = candidate
      }

      best
    }
  }
}
