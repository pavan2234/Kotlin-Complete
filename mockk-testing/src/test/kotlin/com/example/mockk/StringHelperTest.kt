package com.example.mockk

import org.junit.Assert.assertArrayEquals
import org.junit.Test
import org.junit.runners.Parameterized
import org.mockito.Mockito.`when`
import org.mockito.Mockito.*
import java.util.*
import kotlin.test.assertEquals


internal class StringHelperTest {

//    @Before
//    fun before(){
//        println("Before the test")
//    }

    @Test
    fun truncateAInFirst2Positions() {
        val obj = StringHelper()
        val actual =  obj.truncateAInFirst2Positions("AACD")
        val expected = "CD"
        assertEquals(actual, expected)
        println("Test1")
    }
    @Test
    fun areFirstAndLastTwoCharactersTheSame(){
        val obj = StringHelper()
        val actual = obj.areFirstAndLastTwoCharactersTheSame("ABAB")
        val expected = true
        assertEquals(actual,expected)
        println("Test2")
    }
//    @After
//    fun after(){
//        println("After the test")
//    }
    @Test
    fun testArraySort_RandomArray() {
        val numbers = intArrayOf(12, 3, 4, 1)
        val expected = intArrayOf(1, 3, 4, 12)
        Arrays.sort(numbers)
        assertArrayEquals(expected, numbers)
    }

    @Test(expected = NullPointerException::class)
    fun testArraySort_NullArray() {
        val numbers: IntArray? = null
        Arrays.sort(numbers)
    }

    @Test(timeout = 100)
    fun testSort_Performance() {
        val array = intArrayOf(12, 23, 4)
        for (i in 1..1000000) {
            array[0] = i
            Arrays.sort(array)
        }
    }

    @Parameterized.Parameters
    fun testConditions(): Collection<Array<String>>? {
        val expectedOutputs = arrayOf(arrayOf("AACD", "CD"), arrayOf("ACD", "CD"))
        return Arrays.asList(*expectedOutputs)
    }

    @Test
    fun Test() {
        val listmockk: List<*> = mock(MutableList::class.java)
        `when`(listmockk.size).thenReturn(2)
        assertEquals(2, listmockk.size)
    }

    @Test
    fun mockktest(){
        val listmockk:List<*> = mock(MutableList::class.java)
        `when`(listmockk.get(anyInt())).thenReturn("This is mock testing")
        assertEquals("This is mock testing",listmockk.get(0))
        assertEquals("This is mock testing",listmockk.get(1))
    }

    @Test(expected = RuntimeException::class)
    fun mockktest2(){
        val listmockk:List<*> = mock(MutableList::class.java)
        `when`(listmockk.get(anyInt())).thenThrow(RuntimeException::class.java)
        listmockk.get(0)
    }

    @Test(expected = RuntimeException::class)
    fun mockktest3(){
        val listmockk:List<*> = mock(MutableList::class.java)
        `when`(listmockk.subList(anyInt(),5)).thenThrow(RuntimeException::class.java)
        listmockk.get(0)
    }

}