package test

import main.Graph
import org.testng.annotations.Test
import kotlin.test.assertEquals

class Tests {
    val graph = Graph()

    init {
        for (i in 1..11) {
            graph.add(i)
        }
        graph.makeNeighbors(1, 2)
        graph.makeNeighbors(1, 3)
        graph.makeNeighbors(1, 4)
        graph.makeNeighbors(2, 3)
        graph.makeNeighbors(3, 4)
        graph.makeNeighbors(3, 5)
        graph.makeNeighbors(5, 6)
        graph.makeNeighbors(6, 7)
        graph.makeNeighbors(5, 8)
        graph.makeNeighbors(8, 9)
        graph.makeNeighbors(5, 10)
        graph.makeNeighbors(5, 11)
    }

    @Test
    fun DFSTest() {
        println(graph.DFS(1, 6))
        println(graph.DFS(1, 4))
        println(graph.DFS(3, 6))
        println(graph.DFS(2, 4))
        println(graph.DFS(4, 7))
    }

    @Test
    fun breadthFirstSearchTest(){
        println(graph.breadthFirstSearch(1, 6))
        println(graph.breadthFirstSearch(1, 4))
        println(graph.breadthFirstSearch(3, 6))
        println(graph.breadthFirstSearch(2, 4))
        println(graph.breadthFirstSearch(4, 7))
    }
}