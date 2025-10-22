## Objective

Empirically determine the time complexity characteristics of two sorting algorithms (`sort1`, `sort2`) by measuring operation counts across multiple input sizes and data distributions.

## Code Modification

The list generator used to produce test inputs is shown below. It supports four data types: `random`, `identical`, `sort` (already sorted ascending), and `reverse-sorted` (descending).

```python
def __list_generator(kind, length):
    """
    creates a <kind> list with <length> numbers
    :param kind: data type like "random", "identical", "reverse-sorted", etc.
    :param length: number of numbers that should be placed into list
    :return: the finished list
    """
    data = []
    if kind == "random":
        for i in range(length):
            data.append(random.randint(1,length))
    elif kind == "identical":
        value = random.randint(1,length)
        for i in range(length):
            data.append(value)
    elif kind == "sort":
        for i in range(length):
            data.append(i + 1)
    elif kind == "reverse-sorted":
        for i in range(length, 0 , -1):
            data.append(i + 1)

    return data
```

Input sizes used:
- For `sort1`: `n ∈ [10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120]`
- For `sort2`: `n ∈ [1000, 1500, 2000, 3000, 4000, 5500, 7000, 9000, 11000, 13000]`

 

## Data Tables

Operation counts (list accesses) come from `out.txt` after running the experiments.

### Random

#### sort1 (random)

| n | ops |
|---:|---:|
| 10 | 94 |
| 20 | 228 |
| 40 | 519 |
| 80 | 1164 |
| 160 | 2635 |
| 320 | 5875 |
| 640 | 12752 |
| 1280 | 29267 |
| 2560 | 62536 |
| 5120 | 138710 |

#### sort2 (random)

| n | ops |
|---:|---:|
| 1000 | 29998000 |
| 1500 | 29997000 |
| 2000 | 29996000 |
| 3000 | 29994000 |
| 4000 | 47725238 |
| 5500 | 89222874 |
| 7000 | 145518958 |
| 9000 | 239817596 |
| 11000 | 361911110 |
| 13000 | 503531208 |

### Sorted (ascending)

#### sort1 (sort)

| n | ops |
|---:|---:|
| 10 | 110 |
| 20 | 325 |
| 40 | 1055 |
| 80 | 3715 |
| 160 | 13835 |
| 320 | 53275 |
| 640 | 208955 |
| 1280 | 827515 |
| 2560 | 3293435 |
| 5120 | 13140475 |

#### sort2 (sort)

| n | ops |
|---:|---:|
| 1000 | 29998000 |
| 1500 | 29997000 |
| 2000 | 29996000 |
| 3000 | 29994000 |
| 4000 | 29992000 |
| 5500 | 29989000 |
| 7000 | 29986000 |
| 9000 | 29982000 |
| 11000 | 29978000 |
| 13000 | 29974000 |

### Reverse‑sorted (descending)

#### sort1 (reverse-sorted)

| n | ops |
|---:|---:|
| 10 | 105 |
| 20 | 315 |
| 40 | 1035 |
| 80 | 3675 |
| 160 | 13755 |
| 320 | 53115 |
| 640 | 208635 |
| 1280 | 826875 |
| 2560 | 3292155 |
| 5120 | 13137915 |

#### sort2 (reverse-sorted)

| n | ops |
|---:|---:|
| 1000 | 29998000 |
| 1500 | 29997000 |
| 2000 | 29996000 |
| 3000 | 35994000 |
| 4000 | 63992000 |
| 5500 | 120989000 |
| 7000 | 195986000 |
| 9000 | 323982000 |
| 11000 | 483978000 |
| 13000 | 675974000 |

### Identical

#### sort1 (identical)

| n | ops |
|---:|---:|
| 10 | 87 |
| 20 | 215 |
| 40 | 511 |
| 80 | 1183 |
| 160 | 2687 |
| 320 | 6015 |
| 640 | 13311 |
| 1280 | 29183 |
| 2560 | 63487 |
| 5120 | 137215 |

#### sort2 (identical)

| n | ops |
|---:|---:|
| 1000 | 29998000 |
| 1500 | 29997000 |
| 2000 | 29996000 |
| 3000 | 29994000 |
| 4000 | 29992000 |
| 5500 | 29989000 |
| 7000 | 29986000 |
| 9000 | 29982000 |
| 11000 | 29978000 |
| 13000 | 29974000 |

## Graphs

Two combined charts (all data types plotted) were created in Google Sheets from the pivot tables:

![sort1_all](plots/sort1_all.png)

![sort2_all](plots/sort2_all.png)

## Analysis (short)

- **Worst case (reverse‑sorted)**
  - Evidence (sort1):
    
    | n | ops |
    |---:|---:|
    | 640 | 208,635 |
    | 1280 | 826,875 |
    
    Doubling n (640→1280) ≈ 4× ops (208,635→826,875) ⇒ matches O(n^2).
  - Evidence (sort2):
    
    | n | ops |
    |---:|---:|
    | 3000 | 35,994,000 |
    | 7000 | 195,986,000 |
    
    Larger input grows much faster than linear; ratios are consistent with quadratic growth ⇒ O(n^2).

- **Normal/typical case**
  - Evidence (sort1, random):
    
    | n | ops |
    |---:|---:|
    | 640 | 12,752 |
    | 1280 | 29,267 |
    
    Doubling n gives ~2.3× ops ⇒ close to O(n log n).
  - Evidence (sort2, sorted):
    
    | n | ops |
    |---:|---:|
    | 4000 | 29,992,000 |
    | 11000 | 29,978,000 |
    
    Very small change as n increases ⇒ near best‑case; overhead dominates at these sizes.

- **Takeaways**
  - Worst‑case: both sorts behave like O(n^2) on reverse‑sorted data.
  - Typical case: sort1 ≈ O(n log n) (random), sort2 is fast on ordered/identical (near linear/constant‑dominated).

- **Inferred Big‑O**
  - **sort1**: Average‑case approximately **O(n log n)**; worst‑case approximately **O(n^2)** on ordered inputs.
  - **sort2**: Best‑case approximately **O(n)** on ordered/identical inputs; worst‑case approximately **O(n^2)** on reverse‑sorted; random appears between linear and quadratic, trending upward with n.

## Conclusion

- **Final complexities**
  - **sort1**: ~O(n log n) average; ~O(n^2) worst‑case.
  - **sort2**: ~O(n) best‑case (ordered/identical); ~O(n^2) worst‑case (reverse‑sorted).

- **Notable observations**
  - `sort1` is highly sensitive to already‑ordered inputs (both ascending and descending) in this implementation, suggesting a pivot/partitioning strategy or inner‑loop pattern that degenerates on ordered data.
  - `sort2` shows behavior consistent with insertion‑like logic (fast on ordered input, quadratic on reverse‑sorted), but with a sizable fixed overhead in our counting metric that flattens small‑n curves.

- **Potential sources of experimental error**
  - Using operation counts (list accesses) as a proxy for time can include large constant factors, masking growth at small n.
  - Python interpreter noise, memory effects, and OS scheduling may add variance.
  - Randomness not seeded; different runs can produce slightly different `random` results.
  - Distinct n‑ranges for `sort1` vs `sort2` reduce direct point‑by‑point comparability.

 

