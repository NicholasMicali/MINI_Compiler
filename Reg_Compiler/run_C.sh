
#gcc output_executable -Wno-parentheses-equality -Wno-tautological-comparen benchmarks/$1/$1.c
clang -O3 -o output_executable -Wno-parentheses-equality -Wno-tautological-compare benchmarks/$1/$1.c
startT=$(python -c 'import time; print(int(time.time() * 1000))')
./output_executable < benchmarks/$1/input > benchmarks/$1/output
endT=$(python -c 'import time; print(int(time.time() * 1000))')
runtime=$(($endT - $startT))
echo "$1 Execution time: $runtime milliseconds"

