	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 11, 0
	.globl	_function                       ## -- Begin function function
	.p2align	4, 0x90
_function:                              ## @function
	.cfi_startproc
## %bb.0:                               ## %LU0
	pushq	%r15
	.cfi_def_cfa_offset 16
	pushq	%r14
	.cfi_def_cfa_offset 24
	pushq	%r12
	.cfi_def_cfa_offset 32
	pushq	%rbx
	.cfi_def_cfa_offset 40
	pushq	%rax
	.cfi_def_cfa_offset 48
	.cfi_offset %rbx, -40
	.cfi_offset %r12, -32
	.cfi_offset %r14, -24
	.cfi_offset %r15, -16
	testq	%rdi, %rdi
	jg	LBB0_3
## %bb.1:                               ## %LU1
	xorl	%eax, %eax
	jmp	LBB0_2
LBB0_3:                                 ## %LU2
	movq	%rdi, %rbx
	movq	%rdi, %r15
	imulq	%rbx, %r15
	testq	%r15, %r15
	jle	LBB0_6
## %bb.4:                               ## %LU3.preheader
	movl	$1, %r12d
	leaq	L_.print(%rip), %r14
	.p2align	4, 0x90
LBB0_5:                                 ## %LU3
                                        ## =>This Inner Loop Header: Depth=1
	leaq	-1(%rbx,%r12), %rsi
	movq	%r14, %rdi
	xorl	%eax, %eax
	callq	_printf
	cmpq	%r15, %r12
	leaq	1(%r12), %r12
	jl	LBB0_5
LBB0_6:                                 ## %LU4
	decq	%rbx
	movq	%rbx, %rdi
	callq	_function
LBB0_2:                                 ## %LU1
	addq	$8, %rsp
	popq	%rbx
	popq	%r12
	popq	%r14
	popq	%r15
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_main                           ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## %bb.0:                               ## %LU5
	pushq	%rbx
	.cfi_def_cfa_offset 16
	.cfi_offset %rbx, -16
	leaq	L_.read(%rip), %rdi
	movq	_.read_scratch@GOTPCREL(%rip), %rbx
	movq	%rbx, %rsi
	xorl	%eax, %eax
	callq	_scanf
	movq	(%rbx), %rdi
	callq	_function
	leaq	L_.println(%rip), %rdi
	xorl	%esi, %esi
	xorl	%eax, %eax
	callq	_printf
	xorl	%eax, %eax
	popq	%rbx
	retq
	.cfi_endproc
                                        ## -- End function
	.section	__TEXT,__cstring,cstring_literals
L_.println:                             ## @.println
	.asciz	"%ld\n"

L_.print:                               ## @.print
	.asciz	"%ld "

L_.read:                                ## @.read
	.asciz	"%ld"

	.comm	_.read_scratch,8,3              ## @.read_scratch
.subsections_via_symbols
