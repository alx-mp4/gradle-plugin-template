# Contributing

## Workflow Guidelines
- **External contributors** should fork the repository and open pull requests to `master` with their changes.
- **Write-access users** can commit directly to `master`, but they should follow the PR-based workflow if they are unsure about their changes.

Once reviewed and approved, changes will be **squash merged** into `master` to maintain a clean history.

> [!WARNING]
> **Pull requests that do not follow these instructions will be rejected.**<br/>
> You will receive a comment explaining what was incorrect, so you can make the necessary changes and resubmit.

## Coding Conventions
This is an open-source project. Keep in mind the people who will read and work with your code—make it clean and easy to understand.

When reading the code, you'll quickly get the hang of it. Focus on optimizing for readability:

- Do not leave zombie code behind.
- Clean and concise comments are encouraged if they improve understanding.
- Use an indentation of **four spaces** whenever possible; **two spaces are also acceptable** if preferred.
- Follow object-oriented principles such as SOLID to improve code maintainability.
- Prefer Java Streams and functional programming when applicable, as they improve code readability and performance.
- Use proper Java keywords and modifiers to ensure encapsulation and best practices:
- Always include spaces:
  - After list items and method parameters (e.g., `[1, 2, 3]`, not `[1,2,3]`).
  - Around operators (e.g., `x += 1`, not `x+=1`).
  - Around hash arrows, curly braces, etc.
- If possible, please avoid algorithms with bad space and time complexity.
  - Learn more about Big O notation [here](https://en.wikipedia.org/wiki/Big_O_notation).

Following these conventions will help maintain high-quality code and make contributions easier for everyone.  
