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

    fun breadthFirstSearch(from: Int, to: Int): List<Int> { //Поиск в ширину
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.addLast(Pair(from, 0))
        val visited = mutableMapOf<Int, Int>()
        visited.put(from, 0)
        while (!deque.isEmpty()){
            val current = deque.first()
            if (current.first == to){
                break
            }
            deque.removeFirst()
            for (neighbor in getNeighbors(current.first)){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor, current.second + 1)
                    deque.addLast(Pair(neighbor, current.second + 1))
                }
            }
        }
        if (!deque.isEmpty()) {
            val way = mutableListOf<Int>()
            val last = deque.first()
            way.add(0, last.first)
            var distance = last.second
            var current = last.first
            while (distance > 0) {
                for (neighbor in getNeighbors(current)){
                    if (visited.containsKey(neighbor) && visited[neighbor]!! < distance){
                        way.add(0, neighbor)
                        current = neighbor
                        break
                    }
                }
                distance--
            }
            return way
        } else {
            throw NoSuchElementException()
        }
    }


    fun DFS(from: Int, to: Int): List<Int> { //Поиск в глубину
        val deque = ArrayDeque<Int>()
        deque.push(from)
        val visited = mutableSetOf<Int>()
        val way = mutableListOf<Int>()
        way.add(from)
        while (!deque.isEmpty()) {
            val current = deque.peek()
            visited.add(current)
            if (way.last() != current){
                way.add(current)
            }
            if (current == to){
                return way
            }
            var hasNotVisitedNeighbors = false
            for (neighbor in getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    deque.push(neighbor)
                    hasNotVisitedNeighbors = true
                }
            }
            if (!hasNotVisitedNeighbors){
                way.removeAt(way.lastIndex)
                deque.pop()
            }
        }
        throw NoSuchElementException()
    }
}