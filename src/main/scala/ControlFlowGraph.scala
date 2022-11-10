import better.files.File
import soot.{G, Main, PackManager}
import soot.options.Options

import scala.jdk.CollectionConverters._

object ControlFlowGraph {
  def loadCFG(jarFile:File): Unit = {

  }


  def loadApk(path : String):Unit ={
    G.reset()

    Options.v.set_allow_phantom_refs(true)
    //Options.v.set_output_format(1) //TODO: dbg output?
    Options.v.set_output_format(Options.output_format_none)

    //TODO: added from jpf example
    import soot.Scene
    import soot.SootClass
    Scene.v.addBasicClass("java.lang.System", SootClass.SIGNATURES)
    Scene.v.addBasicClass("java.lang.Thread", SootClass.SIGNATURES)
    Scene.v.addBasicClass("java.lang.ThreadGroup", SootClass.SIGNATURES)

    Scene.v.addBasicClass("java.lang.ClassLoader", SootClass.SIGNATURES)
    Scene.v.addBasicClass("java.security.PrivilegedActionException", SootClass.SIGNATURES)
    Scene.v.addBasicClass("java.lang.ref.Finalizer", SootClass.SIGNATURES)
    //    val excludedList = FrameworkExtensions.extensionStrings
    //    Options.v().set_exclude(excludedList.asJava)
    Options.v().set_no_bodies_for_excluded(false)
    Options.v.set_whole_program(true)
    Options.v.set_process_dir(List(path).asJava)
    Options.v.set_src_prec(Options.src_prec_class)
    Options.v.set_keep_offset(false) //don't create tag that holds bytecode offset
    Options.v.set_keep_line_number(true)
    //    Options.v.set_throw_analysis(Options.throw_analysis_dalvik) //TODO: disabled, is this needed?
    Options.v.set_process_multiple_dex(true)
    Options.v.set_ignore_resolution_errors(true)
    //    Options.v.setPhaseOption("jb", "use-original-names:true")
    //TODO: construct classpath
    val classpath = System.getProperty("java.class.path") + ":/usr/lib/jvm/java-11-openjdk-amd64/lib"
    Options.v.set_soot_classpath(classpath)
    Main.v.autoSetOptions()
    //    Options.v.setPhaseOption("cg.cha", "on")
    //    Scene.v.loadBasicClasses() // called by loadNecessaryClasses
    Scene.v.loadNecessaryClasses()
    //    Scene.v.loadDynamicClasses() // called by loadNecessaryClasses
    PackManager.v.getPack("wjpp").apply()
    PackManager.v.runPacks()
    //    CHATransformer.v().transform()
    //    Packmanager.v().runPacks()

  }

  def main(args: Array[String]) {
    // prints Hello World
    println("Hello World!")
  }
}
