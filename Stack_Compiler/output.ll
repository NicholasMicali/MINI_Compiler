define i64 @function(i64 %n)
{
LU0:
    %P_n = alloca i64
    store i64 %n, i64* %P_n
    %i = alloca i64
    %j = alloca i64
    %r0 = load i64, i64* %P_n
    %r1 = icmp sle i64 %r0, 0
    %r2 = zext i1 %r1 to i64
    %r3 = trunc i64 %r2 to i1
    br i1 %r3, label %LU1, label %LU2
LU1:
    ret i64 0
LU2:
    store i64 0, i64* %i
    %r4 = load i64, i64* %i
    %r5 = load i64, i64* %P_n
    %r6 = load i64, i64* %P_n
    %r7 = mul i64 %r5, %r6
    %r8 = icmp slt i64 %r4, %r7
    %r9 = zext i1 %r8 to i64
    %r10 = trunc i64 %r9 to i1
    br i1 %r10, label %LU3, label %LU4
LU3:
    %r11 = load i64, i64* %i
    %r12 = load i64, i64* %P_n
    %r13 = add i64 %r11, %r12
    store i64 %r13, i64* %j
    %r14 = load i64, i64* %j
    call i64 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.print, i32 0, i32 0), i64 %r14)
    %r15 = load i64, i64* %i
    %r16 = add i64 %r15, 1
    store i64 %r16, i64* %i
    %r17 = load i64, i64* %i
    %r18 = load i64, i64* %P_n
    %r19 = load i64, i64* %P_n
    %r20 = mul i64 %r18, %r19
    %r21 = icmp slt i64 %r17, %r20
    %r22 = zext i1 %r21 to i64
    %r23 = trunc i64 %r22 to i1
    br i1 %r23, label %LU3, label %LU4
LU4:
    %r24 = load i64, i64* %P_n
    %r25 = sub i64 %r24, 1
    %r26 = call i64 @function(i64 %r25)
    ret i64 %r26
}

define i64 @main()
{
LU5:
    %num = alloca i64
    call i64 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.read, i32 0, i32 0), i64* %num)
    %r27 = load i64, i64* %num
    %r28 = call i64 @function(i64 %r27)
    call i64 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.println, i32 0, i32 0), i64 0)
    ret i64 0
}

declare i8* @malloc(i64)
declare void @free(i8*)
declare i64 @printf(i8*, ...)
declare i64 @scanf(i8*, ...)
@.println = private unnamed_addr constant [5 x i8] c"%ld\0A\00", align 1
@.print = private unnamed_addr constant [5 x i8] c"%ld \00", align 1
@.read = private unnamed_addr constant [4 x i8] c"%ld\00" , align 1
@.read_scratch = common global i64 0, align 4

