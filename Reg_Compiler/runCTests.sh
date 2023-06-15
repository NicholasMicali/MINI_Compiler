my_array=(BenchMarkishTopics bert biggest binaryConverter brett creativeBenchMarkName fact_sum Fibonacci GeneralFunctAndOptimize hailstone hanoi_benchmark killerBubbles mile1 mixed OptimizationBenchmark primes programBreaker stats TicTac wasteOfCycles)

for i in "${my_array[@]}"
do
  ./run_C.sh "$i"
done