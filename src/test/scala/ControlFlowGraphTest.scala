import better.files.File

class ControlFlowGraphTest extends org.scalatest.funsuite.AnyFunSuite {
  test("load a control flow graph"){
    ControlFlowGraph.loadApk("/home/saksham/exampleproj/Foo.class")
    assert(false)
  }
}
