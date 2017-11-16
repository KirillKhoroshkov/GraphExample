package test

import main.Graph
import org.testng.annotations.Test
import kotlin.test.assertEquals

class Tests {

    @Test
    fun breadthFirstSearchTest(){
        val graph = Graph()
        for (i in 1..6){
            graph.add(i)
        }
        graph.makeNeighbors(1, 2)
        graph.makeNeighbors(1, 3)
        graph.makeNeighbors(1, 4)
        graph.makeNeighbors(2, 3)
        graph.makeNeighbors(3, 4)
        graph.makeNeighbors(3, 5)
        graph.makeNeighbors(5, 6)
        assertEquals(graph.breadthFirstSearch(1, 6), 3)
        assertEquals(graph.breadthFirstSearch(1, 4), 1)
        assertEquals(graph.breadthFirstSearch(3, 6), 2)
        assertEquals(graph.breadthFirstSearch(2, 4), 2)
    }
}