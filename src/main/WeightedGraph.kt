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
            val deque = ArrayDeque<Int>()
            deque.addLast(from)
            val visited = mutableMapOf<Int, Int>()
            visited.put(from, 0)
            while (!deque.isEmpty()) {
                val current = deque.pollFirst()
                for ((key, value) in getNeighbors(current)) {
                    val distance = visited[current]!! + value
                    if (!visited.containsKey(key)) {
                        visited.put(key, distance)
                        deque.addLast(key)
                    } else if (visited[key]!! > distance) {
                        visited[key] = distance
                    }
                }
            }
            return visited
        }
    }
}