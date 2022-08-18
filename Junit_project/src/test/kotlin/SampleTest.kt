import org.junit.Test


internal class SampleTest{
    private val test:Sample=Sample()
    @Test
    fun testSum() {
        val expected = 43
        kotlin.test.assertEquals(expected, test.sum(40, 3))
    }
}