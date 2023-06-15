# MINI_Compiler

This is a Compiler for a self-defined language called MINI. MINI is a simple language with Functions, globals, structs, and other normal language syntax. This project compiles the MINI syntax down to llvm and can be run against the provided benchmarks in a variety of configurations. The Stack-based compiler stores all llvm registers on the stack, while the Register based compiler stores them in virtual registers, and can be optimized. 

Run instructions are listed below


install llvm

run: 
export PATH="/usr/local/opt/llvm/bin:$PATH"

then compile with make command: 
make all

run single or all tests with commands below [] indicate optional optimization commands 
- (-cp for constant propogation and -lv for local value numbering) (Both are only available for the register-based compiler)

run with any benchmark: ./run_mini.sh filename [-cp] [-lv]

run with all benchmark tests: ./run_tests.sh [-cp] [-lv]

to add permissions to a file if necessary chmod u+x filename
