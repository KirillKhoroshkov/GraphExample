package main

import java.util.*
import kotlin.NoSuchElementException

class WeightedGraph {

    private val vertexes = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun add(name :Int){
        vertexes.put(name, mutableMapOf())
    }

    fun makeNeighbors(first: Int, second: Int, weight: Int){
        if (vertexes.containsKey(first) && vertexes.containsKey(second)){
            vertexes[first]!!.put(second, weight)
            vertexes[second]!!.put(first, weight)
        } else {
            throw NoSuchElementException()
        }
    }

    fun getNeighbors(vertex: Int): MutableMap<Int, Int> {
        if (vertexes.containsKey(vertex)) {
            return vertexes[vertex]!!
        } else {
            throw NoSuchElementException()
        }
    }

    fun algorithmOfDijkstra(from: Int): Map<Int, Int> {
        if (!vertexes.containsKey(from)) {
            throw NoSuchElementException()
        } else {
            val deque = ArrayDeque<Pair<Int, Int>>()
            deque.addLast(Pair(from, 0))
            val visited = mutableMapOf<Int, Int>()
            visited.put(from, 0)
            while (!deque.isEmpty()) {
                val current = deque.pollFirst()
                for (neighbor in getNeighbors(current.first)) {
                    val distance = current.second + neighbor.value
                    if (!visited.containsKey(neighbor.key)) {
                        visited.put(neighbor.key, distance)
                        deque.addLast(Pair(neighbor.key, distance))
                    } else if (visited[neighbor.key]!! > distance) {
                        visited.put(neighbor.key, distance)
                    }
                }
            }
            return visited
        }
    }
}