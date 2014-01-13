import sbt._
import Keys._
import com.typesafe.sbteclipse.core.EclipsePlugin._

object ProjectBuild extends Build {
  override val settings = super.settings ++ Seq(
    organization := "com.example",    
    name := "sbt-java",    
    version := "0.0.1-SNAPSHOT",    
    
    scalaVersion := "2.10.3",
    scalacOptions ++= Seq( "-encoding", "UTF-8", "-target:jvm-1.7" ),    
    javacOptions ++= Seq( "-encoding", "UTF-8", "-source", "1.7", "-target", "1.7" ),        
    outputStrategy := Some( StdoutOutput ),
    compileOrder := CompileOrder.JavaThenScala,
    
    resolvers ++= Seq( 
        Resolver.mavenLocal, 
        Resolver.sonatypeRepo( "releases" ), 
        Resolver.typesafeRepo( "releases" )
    ),        

    crossPaths := false,            
    fork in run := true,
    connectInput in run := true,
    
    EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)
  )
    
  lazy val main = Project( 
    id = "sbt-java",  
    base = file("."), 
    settings = Project.defaultSettings ++ Seq(      	       
	    mainClass := Some( "com.example.Starter" ),
	    
	    initialCommands in console += """
	          import com.example._
	          import com.example.Starter._
	          import org.springframework.context.annotation._
	      """,
	      
	    libraryDependencies ++= Seq(
	        "org.springframework" % "spring-context" % "4.0.0.RELEASE",
	        "org.springframework" % "spring-beans" % "4.0.0.RELEASE",
	        "org.springframework" % "spring-test" % "4.0.0.RELEASE" % "test",
	        "com.novocode" % "junit-interface" % "0.10" % "test",
	        "junit" % "junit" % "4.11" % "test"
	    )
	  ) 
  )  
}