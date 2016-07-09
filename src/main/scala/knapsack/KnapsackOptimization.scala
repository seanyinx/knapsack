package knapsack

case class KnapsackOptimization(capacity: Int) {

  def select(elements: Map[Int, Int]): Map[Int, Int] = {
    if (elements.keys.sum <= capacity) {
      elements
    }
    else {
      var best = Map.empty[Int, Int]
      for {
        element <- elements
        subset = select(elements - element._1)

        if subset.values.sum > best.values.sum
      } {
        best = subset
      }

      best
    }
  }
}
