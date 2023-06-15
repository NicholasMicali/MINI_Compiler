define i64 @function(i64 %n)
{
LU0:
    %r0 = icmp sle i64 %n, 0
    %r1 = zext i1 %r0 to i64
    %r2 = trunc i64 %r1 to i1
    br i1 %r2, label %LU1, label %LU2
LU1:
    ret i64 0
LU2:
    %r3 = mul i64 %n, %n
    %r4 = icmp slt i64 0, %r3
    %r5 = zext i1 %r4 to i64
    %r6 = trunc i64 %r5 to i1
    br i1 %r6, label %LU3, label %LU4
LU3:
    %r8 = phi i64 [%n, %LU2], [%r8, %LU3]
    %r7 = phi i64 [0, %LU2], [%r10, %LU3]
    %r9 = add i64 %r7, %r8
    call i64 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.print, i32 0, i32 0), i64 %r9)
    %r10 = add i64 %r7, 1
    %r11 = mul i64 %r8, %r8
    %r12 = icmp slt i64 %r10, %r11
    %r13 = zext i1 %r12 to i64
    %r14 = trunc i64 %r13 to i1
    br i1 %r14, label %LU3, label %LU4
LU4:
    %r15 = phi i64 [%n, %LU2], [%r8, %LU3]
    %r16 = sub i64 %r15, 1
    %r17 = call i64 @function(i64 %r16)
    ret i64 %r17
}

define i64 @main()
{
LU5:
    call i64 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.read, i32 0, i32 0), i64* @.read_scratch)
    %r18 = load i64, i64* @.read_scratch
    %r19 = call i64 @function(i64 %r18)
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

