class CubeCalculatorTest extends org.scalatest.funsuite.AnyFunSuite {
  test("CubeCalculator.cube computes volume of cube") {
    assert(CubeCalculator.cube(3) === 27)
  }
  test("some new behavior"){
    println(s"test is running ${1+1}")
  }
}
