#!/bin/bash
cd ../
mvn -DaltDeploymentRepository=snapshot-repo::default::file:mvn-repository clean deploy
