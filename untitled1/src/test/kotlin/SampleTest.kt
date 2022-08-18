import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {

     private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expected = 43
        assertEquals(expected, testSample.sum(40, 3))
//        val expected2 = 45
//        assertEquals(expected2,testSample.sum(40,5))
    }
}