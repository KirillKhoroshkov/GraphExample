package main

import java.util.*
import kotlin.NoSuchElementException

class Graph {

    private val vertexes = mutableMapOf<Int, MutableSet<Int>>()

    fun add(name :Int){
        vertexes.put(name, mutableSetOf())
    }

    fun makeNeighbors(first: Int, second: Int){
        if (vertexes.containsKey(first) && vertexes.containsKey(first)){
            vertexes[first]!!.add(second)
            vertexes[second]!!.add(first)
        } else {
            throw NoSuchElementException()
        }
    }

    fun getNeighbors(vertex: Int): MutableSet<Int> {
        if (vertexes.containsKey(vertex)) {
            return vertexes[vertex]!!
        } else {
            throw NoSuchElementException()
        }
    }

    fun breadthFirstSearch(from: Int, to: Int): Int { //Поиск в ширину
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(Pair(from, 0))
        val visited = mutableListOf<Int>()
        while (!deque.isEmpty()){
            val current = deque.pop()
            visited.add(current.first)
            if (current.first == to){
                return current.second
            }
            for (neighbor in getNeighbors(current.first)){
                if (!visited.contains(neighbor)){
                    deque.add(Pair(neighbor, current.second + 1))
                }
            }
        }
        throw NoSuchElementException()
    }
}