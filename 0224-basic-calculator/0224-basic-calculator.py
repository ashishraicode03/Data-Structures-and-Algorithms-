class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        RPN = []
        ans = []
        Input = []
        current_num = ""
        for char in s:
            if char == ' ':
                continue 
            if char.isdigit():
                current_num += char
            else:
                if current_num:
                    Input.append(current_num)
                    current_num = ""
                if char == '-' and (not Input or Input[-1] == '('):
                    Input.append('0')
                Input.append(char)
        if current_num:
            Input.append(current_num)
        for i in Input:
            if i in '+-*/()':
                if i in '+-':
                    while stack and stack[-1] in '+-*/':
                        RPN.append(stack.pop())
                    stack.append(i)
                elif i in '*/':
                    while stack[-1] in '*/':
                        RPN.append(stack.pop())
                    stack.append(i)
                elif i == '(':
                    stack.append(i)
                elif i == ')':
                    while stack[-1] != '(':
                        RPN.append(stack.pop())
                    stack.pop()
            else: RPN.append(i)
        RPN+=stack
        for num in RPN:
            if num in '+-*/':
                b = int(ans.pop())
                a = int(ans.pop())
                if num == '+':
                    ans.append(a+b)
                elif num == '-':
                    ans.append(a-b)
                elif num == '*':
                    ans.append(a*b)
                elif num == '/':
                    ans.append(int(a/b))
            else: ans.append(num)
        return int(ans[0])