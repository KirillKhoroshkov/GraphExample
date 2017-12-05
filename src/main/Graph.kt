package main

import java.util.*
import kotlin.NoSuchElementException

class Graph {

    private val vertexes = mutableMapOf<Int, MutableSet<Int>>()

    fun add(name :Int){
        vertexes.put(name, mutableSetOf())
    }

    fun makeNeighbors(first: Int, second: Int){
        if (vertexes.containsKey(first) && vertexes.containsKey(second)){
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

    fun breadthFirstSearch(from: Int, to: Int): List<Int>{ //Поиск в ширину
        val deque = ArrayDeque<Int>()
        deque.addLast(from)
        val visited = mutableMapOf<Int, Int>()
        visited.put(from, 0)
        println(from)
        while (!deque.isEmpty()){
            val current = deque.first()
            deque.removeFirst()
            var hasNotVisited = false
            for (neighbor in getNeighbors(current)){
                if (!visited.containsKey(neighbor)){
                    hasNotVisited = true
                    print("$neighbor ")
                    visited.put(neighbor, visited[current]!! + 1)
                    deque.addLast(neighbor)
                }
            }
            if (hasNotVisited){
                println()
            }
        }
        if (visited.containsKey(to)) {
            val path = mutableListOf<Int>()
            var current = to
            path.add(current)
            while (current != from){
                for (neighbor in getNeighbors(current)){
                    if (visited[neighbor]!! < visited[current]!!){
                        current = neighbor
                        path.add(neighbor)
                        break
                    }
                }
            }
            return path
        } else {
            throw NoSuchElementException()
        }
    }


    fun depthFirstSearch(from: Int, to: Int): List<Int> { //Поиск в глубину
        val deque = ArrayDeque<Int>()
        deque.push(from)
        val visited = mutableSetOf<Int>()
        val way = mutableListOf<Int>()
        var isPathFound = false
        way.add(from)
        println(from)
        while (!deque.isEmpty()) {
            val current = deque.peek()
            visited.add(current)
            if (!isPathFound && way.last() != current){
                way.add(current)
            }
            if (current == to){
                isPathFound = true
            }
            var hasNotVisitedNeighbors = false
            for (neighbor in getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    print(neighbor.toString() + " ")
                    deque.push(neighbor)
                    hasNotVisitedNeighbors = true
                }
            }
            if (!hasNotVisitedNeighbors){
                if (!isPathFound) {
                    way.removeAt(way.lastIndex)
                }
                deque.pop()
            } else {
                println()
            }
        }
        if (isPathFound){
            return way
        }
        throw NoSuchElementException()
    }

}