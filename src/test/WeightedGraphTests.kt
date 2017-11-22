package test

import main.WeightedGraph
import org.testng.annotations.Test

class WeightedGraphTests {
    val graph = WeightedGraph()

    init {
        for (i in 1..10) {
            graph.add(i)
        }
        graph.makeNeighbors(1, 10, 20)
        graph.makeNeighbors(1, 3, 8)
        graph.makeNeighbors(2, 10, 6)
        graph.makeNeighbors(2, 4, 1)
        graph.makeNeighbors(3, 4, 20)
        graph.makeNeighbors(4, 5, 2)
        graph.makeNeighbors(4, 7, 5)
        graph.makeNeighbors(4, 6, 7)
        graph.makeNeighbors(5, 8, 4)
        graph.makeNeighbors(5, 9, 8)
        graph.makeNeighbors(7, 8, 2)
    }

    @Test
    fun first(){
        println(graph.algorithmOfDijkstra(4))
    }
}