
if [ "$#" -eq 1 ]; then
  java -cp :antlr-4.12.0-complete.jar:javax.json-1.0.jar MiniCompiler benchmarks/$1/$1.mini
  #wc -l output.ll
  llc output.ll -o output.s
  clang -c -o output.o output.s
  clang -o output_executable output.o

  #startT=$(python -c 'import time; print(int(time.time() * 1000))')
  ./output_executable < benchmarks/$1/input > benchmarks/$1/output
  #endT=$(python -c 'import time; print(int(time.time() * 1000))')
  #runtime=$(($endT - $startT))
  #echo "Execution time: $runtime milliseconds"

  diff -q benchmarks/$1/output benchmarks/$1/output.expected
  if [ "$?" -eq 0 ]; then
        echo "$1: PASS"
      else
        echo "$1: FAIL"
      fi
fi

if [ "$#" -eq 2 ]; then
  java -cp :antlr-4.12.0-complete.jar:javax.json-1.0.jar MiniCompiler benchmarks/$1/$1.mini $2
  #wc -l output.ll
  llc output.ll -o output.s
  clang -c -o output.o output.s
  clang -o output_executable output.o

  #startT=$(python -c 'import time; print(int(time.time() * 1000))')
  ./output_executable < benchmarks/$1/input > benchmarks/$1/output
  #endT=$(python -c 'import time; print(int(time.time() * 1000))')
  #runtime=$(($endT - $startT))
  #echo "Execution time: $runtime milliseconds"

  if [ "$?" -eq 0 ]; then
        echo "$1: PASS"
      else
        echo "$1: FAIL"
      fi
fi

if [ "$#" -eq 3 ]; then
  java -cp :antlr-4.12.0-complete.jar:javax.json-1.0.jar MiniCompiler benchmarks/$1/$1.mini $2 $3
  #wc -l output.ll
  llc output.ll -o output.s
  clang -c -o output.o output.s
  clang -o output_executable output.o

  #startT=$(python -c 'import time; print(int(time.time() * 1000))')
  ./output_executable < benchmarks/$1/input > benchmarks/$1/output
  #endT=$(python -c 'import time; print(int(time.time() * 1000))')
  #runtime=$(($endT - $startT))
  #echo "Execution time: $runtime milliseconds"

  if [ "$?" -eq 0 ]; then
        echo "$1: PASS"
      else
        echo "$1: FAIL"
      fi
fi