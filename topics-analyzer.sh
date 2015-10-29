#!/usr/bin/env bash
mvn clean test
mvn exec:java -Dexec.mainClass="es.upm.oeg.lab.analyzers.TopicsAnalyzer" -Dexec.classpathScope="test" > log-$now 2>&1 &

