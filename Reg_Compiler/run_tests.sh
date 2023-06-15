# Run 20 tests

my_array=(BenchMarkishTopics bert biggest binaryConverter brett creativeBenchMarkName fact_sum Fibonacci GeneralFunctAndOptimize hailstone hanoi_benchmark killerBubbles mile1 mixed OptimizationBenchmark primes programBreaker stats TicTac wasteOfCycles)

for i in "${my_array[@]}"
do
  if [ "$#" -eq 0 ]; then
    ./run_mini.sh "$i"
  fi
  if [ "$#" -eq 1 ]; then
    ./run_mini.sh "$i" $1
  fi
  if [ "$#" -eq 2 ]; then
    ./run_mini.sh "$i" $1 $2
  fi
done






