{
  "uri" : "sig2006-p519-weiss_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2006/p519-weiss_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Fast Median and Bilateral Filtering",
    "published" : "2006",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Ben-Weiss",
      "name" : "Ben",
      "surname" : "Weiss"
    } ]
  },
  "bagOfWords" : [ "Ben", "Weiss", "Shell", "Slate", "Software", "Corp.", "median", "filter", "cornerstone", "modern", "image", "processing", "use", "extensively", "smoothing", "de-noising", "application", "we", "introduce", "cpu-based", "vectorizable", "-lrb-", "log", "-rrb-", "algorithm", "median", "filter", "we", "knowledge", "most", "efficient", "yet", "develop", "we", "algorithm", "extend", "image", "any", "bit-depth", "can", "also", "adapt", "perform", "bilateral", "filter", "8-bit", "datum", "we", "median", "filter", "outperform", "photoshop?s", "implementation", "up", "factor", "fifty", "cr", "category", "F.", "2.2", "-lsb-", "analysis", "algorithm", "Problem", "Complexity", "-rsb-", "nonnumerical", "algorithm", "problem", "sort", "searching", "i.", "4.3", "-lsb-", "image", "processing", "computer", "Vision", "-rsb-", "enhancement", "filter", "D.", "2.8", "-lsb-", "Software", "Engineering", "-rsb-", "metric", "Complexity", "measure", "E.", "-lsb-", "datum", "structure", "-rsb-", "array", "keyword", "median", "filter", "bilateral", "filter", "rank-order", "filter", "sort", "image", "processing", "algorithm", "histogram", "datum", "structure", "complexity", "simd", "vector", "processing", "many", "common", "image-processing", "technique", "rank-order", "morphological", "processing", "variation", "basic", "median", "algorithm", "filter", "can", "use", "steppingstone", "more", "sophisticated", "effect", "________________________________________", "ben@shellandslate.com", "Adobe", "Photoshop", "cs2", "de", "facto", "standard", "highperformance", "image", "processing", "median", "filter", "scale", "radius", "100", "variety", "-lrb-", "-rrb-", "algorithm", "well", "know", "-lrb-", "e.g.", "huang", "1981", "-rrb-", "obvious", "faster", "algorithm", "should", "exist", "fast", "high-radius", "implementation", "would", "considerable", "theoretical", "practical", "value", "Gil", "et", "al.", "-lsb-", "1993", "-rsb-", "make", "significant", "progress", "tree-based", "-lrb-", "log", "-rrb-", "median-filtering", "algorithm", "its", "per-pixel", "branch", "nature", "render", "ill-suited", "deep-pipelined", "vector-capable", "modern", "processor", "other", "effort", "have", "resort", "massive", "parallelism", "presumption", "single", "processor", "insufficient", "accord", "Wu", "et", "al.", "-lsb-", "2003", "-rsb-", "...", "design", "parallel", "algorithm", "process", "-lsb-", "median", "filter", "-rsb-", "only", "way", "get", "real-time", "response", "we", "knowledge", "present", "-lrb-", "log", "-rrb-", "algorithm", "most", "efficient", "2d", "median", "filter", "yet", "develop", "process", "8-bit", "datum", "up", "fifty", "time", "faster", "than", "Photoshop?s", "median", "filter", "involve", "weighted", "convolution", "which", "weight", "each", "pixel", "depend", "only", "its", "distance", "from", "center", "pixel", "also", "its", "relative", "intensity", "describe", "bilateral", "filter", "have", "nominal", "-lrb-", "-rrb-", "computational", "cost", "per", "pixel", "have", "paradoxical", "property", "become", "faster", "radius", "increase", "-lrb-", "due", "greater", "subsampling", "-rrb-", "also", "have", "some", "potential", "drawback", "also", "discretization", "may", "lead", "further", "loss", "precision", "particularly", "high-dynamic-range", "image", "narrow", "intensity-weighting", "function", "we", "approach", "paper", "first", "illustrate", "conventional", "-lrb-", "-rrb-", "median", "algorithm", "8-bit", "image", "analyze", "its", "performance", "limitation", "we", "show", "how", "we", "approach", "adapt", "higher", "bit-depth", "datum", "16-bit", "HDR", "floating-point", "consequence", "its", "total", "runtime", "scale", "linearly", "image", "area", "-lrb-", "-rrb-", "s-by-s", "image", "difficulty", "redundant", "calculation", "occur", "widely", "space", "time", "interval", "computation", "perhaps", "ten", "thousand", "processor", "cycle", "apart", "so", "can", "combine", "use", "same", "sequential", "logic", "lead", "-lrb-", "-rrb-", "technique", "yet", "eliminate", "redundancy", "key", "dramatically", "faster", "algorithm", "now", "min", "-lrb-", "2r", "128", "-rrb-", "instead", "allocate", "binary", "histogram", "we", "allocate", "single", "8-bit", "compound", "histogram" ],
  "content" : "Ben Weiss Shell & Slate Software Corp. Median filtering is a cornerstone of modern image processing and is used extensively in smoothing and de-noising applications. We introduce a CPU-based, vectorizable O(log r) algorithm for median filtering, to our knowledge the most efficient yet developed. Our algorithm extends to images of any bit-depth, and can also be adapted to perform bilateral filtering. On 8-bit data our median filter outperforms Photoshop?s implementation by up to a factor of fifty. CR Categories: F.2.2 [Analysis of Algorithms and Problem Complexity]: Nonnumerical Algorithms and Problems ? Sorting and Searching; I.4.3 [Image Processing and Computer Vision]: Enhancement ? Filtering ; D.2.8 [Software Engineering]: Metrics ? Complexity Measures; E.1 [Data Structures]: Arrays Keywords: median filtering, bilateral filtering, rank-order filtering, sorting, image processing, algorithms, histograms, data structures, complexity, SIMD, vector processing Many common image-processing techniques such as rank-order and morphological processing are variations on the basic median algorithm, and the filter can be used as a steppingstone to more sophisticated effects. ________________________________________ ? ben@shellandslate.com Adobe ? Photoshop ? CS2 is the de facto standard for highperformance image processing, with a median filter that scales to radius 100. A variety of O(r) algorithms are well known (e.g. Huang 1981), but it is not obvious that a faster algorithm should exist. A fast, high-radius implementation would be of considerable theoretical and practical value. Gil et al. [1993] made significant progress with a tree-based O(log 2 r) median-filtering algorithm, but its per-pixel branching nature renders it ill-suited for deep-pipelined, vector-capable modern processors. Other efforts have resorted to massive parallelism on the presumption that a single processor is insufficient: according to Wu et al. [2003], ?... designing a parallel algorithm to process [the median filter] is the only way to get a real-time response. To our knowledge, the presented O(log r) algorithm is the most efficient 2D median filter yet developed, and processes 8-bit data up to fifty times faster than Photoshop?s Median filter. It involves a weighted convolution in which the weight for each pixel depends not only on its distance from the center pixel, but also its relative intensity. As described, the bilateral filter has nominal O(r 2 ) computational cost per pixel. It has the paradoxical property of becoming faster as the radius increases (due to greater subsampling), but also has some potential drawbacks. Also, the discretization may lead to a further loss of precision, particularly on high-dynamic-range images with narrow intensity-weighting functions. Our approach in this paper will be first to illustrate the conventional O(r) median algorithm for 8-bit images, and analyze its performance and limitations. We will show how our approach adapts to higher bit-depth data, such as 16-bit and HDR floating-point. As a consequence, its total runtime scales linearly with image area: O(S 2 ) for an S-by-S image. The difficulty is that these redundant calculations occur at widely spaced time intervals in the computation; perhaps tens of thousands of processor cycles apart, so they cannot be combined using the same sequential logic that led to the O(r) technique. Yet, eliminating these redundancies is the key to a dramatically faster algorithm. Now, for N <= min(2r, 128), instead of allocating N binary histograms, we allocate a single 8-bit compound histogram H c .",
  "resources" : [ ]
}