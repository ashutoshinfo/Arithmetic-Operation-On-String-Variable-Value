# Arithmetic-Operation-On-String-Variable-Value

## Input: (JSON)
```json
[
   {
      "calculateField":"customFloat1",
      "formula":"10+15"
   },
   {
      "calculateField":"customFloat2",
      "formula":"customFloat1*10"
   },
   {
      "calculateField":"customFloat3",
      "formula":"customFloat2-18"
   },
   {
      "calculateField":"customFloat4",
      "formula":"customFloat3+customFloat2"
   }
]
```
## Output: Map<String, Float>
```json
{
   customFloat1 = 25.0,
   customFloat2 = 250.0,
   customFloat3 = 232.0,
   customFloat4 = 482.0
}
```
