	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 11, 0
	.globl	_function                       ## -- Begin function function
	.p2align	4, 0x90
_function:                              ## @function
	.cfi_startproc
## %bb.0:                               ## %LU0
	pushq	%rbx
	.cfi_def_cfa_offset 16
	subq	$32, %rsp
	.cfi_def_cfa_offset 48
	.cfi_offset %rbx, -16
	movq	%rdi, 8(%rsp)
	testq	%rdi, %rdi
	jg	LBB0_3
## %bb.1:                               ## %LU1
	xorl	%eax, %eax
	jmp	LBB0_2
LBB0_3:                                 ## %LU2
	movq	$0, 16(%rsp)
	movq	8(%rsp), %rax
	imulq	%rax, %rax
	testq	%rax, %rax
	jle	LBB0_6
## %bb.4:                               ## %LU3.preheader
	leaq	L_.print(%rip), %rbx
	.p2align	4, 0x90
LBB0_5:                                 ## %LU3
                                        ## =>This Inner Loop Header: Depth=1
	movq	16(%rsp), %rsi
	addq	8(%rsp), %rsi
	movq	%rsi, 24(%rsp)
	movq	%rbx, %rdi
	xorl	%eax, %eax
	callq	_printf
	movq	16(%rsp), %rax
	incq	%rax
	movq	%rax, 16(%rsp)
	movq	8(%rsp), %rcx
	imulq	%rcx, %rcx
	cmpq	%rcx, %rax
	jl	LBB0_5
LBB0_6:                                 ## %LU4
	movq	8(%rsp), %rdi
	decq	%rdi
	callq	_function
LBB0_2:                                 ## %LU1
	addq	$32, %rsp
	popq	%rbx
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_main                           ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## %bb.0:                               ## %LU5
	pushq	%rax
	.cfi_def_cfa_offset 16
	leaq	L_.read(%rip), %rdi
	movq	%rsp, %rsi
	xorl	%eax, %eax
	callq	_scanf
	movq	(%rsp), %rdi
	callq	_function
	leaq	L_.println(%rip), %rdi
	xorl	%esi, %esi
	xorl	%eax, %eax
	callq	_printf
	xorl	%eax, %eax
	popq	%rcx
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
