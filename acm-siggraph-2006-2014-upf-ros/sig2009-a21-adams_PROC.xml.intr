{
  "uri" : "sig2009-a21-adams_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2009/a21-adams_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Gaussian KD-Trees for Fast High-Dimensional Filtering",
    "published" : null,
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ ]
  },
  "bagOfWords" : [ "recent", "year", "variety", "related", "non-linear", "filter", "have", "become", "important", "various", "task", "image", "processing", "computational", "photography", "geometry", "processing", "related", "field", "include", "bilateral", "filter", "non-local", "means", "filter", "various", "similar", "ad-hoc", "filter", "use", "particular", "application", "filter", "often", "highly", "computationally", "intensive", "we", "present", "framework", "which", "understand", "filter", "acceleration", "datum", "structure", "algorithm", "apply", "broadly", "across", "all", "they", "let", "we", "begin", "simple", "case", "bilateral", "filter", "recent", "method", "accelerate", "bilateral", "filter", "respect", "distance", "space", "luminance", "one", "method", "bilateral", "grid", "-lsb-", "Paris", "Durand", "2006", "-rsb-", "do", "embed", "image", "two", "dimensional", "manifold", "coarsely", "voxelize", "three", "dimensional", "spaceluminance", "volume", "perform", "3d", "gaussian", "blur", "sampling", "again", "along", "image", "manifold", "construct", "output", "shortcoming", "technique", "well", "other", "recent", "acceleration", "bilateral", "filter", "-lsb-", "Durand", "Dorsey", "2002", "-rsb-", "-lsb-", "Weiss", "2006", "-rsb-", "do", "respect", "distance", "chrominance", "result", "unwanted", "blur", "neighbouring", "isoluminant", "region", "-lrb-", "figure", "-rrb-", "one", "way", "address", "problem", "expand", "bilateral", "grid", "5d", "space-color", "volume", "describe", "-lsb-", "Paris", "Durand", "2009", "-rsb-", "however", "we", "argue", "section", "3.1", "memory", "require", "represent", "grid", "grow", "exponentially", "number", "dimension", "do", "time", "require", "each", "stage", "algorithm", "growth", "manageable", "filter", "size", "both", "space", "color", "large", "which", "turn", "permit", "grid", "coarse", "however", "filter", "small", "grid", "must", "fine", "make", "memory", "time", "requirement", "approach", "impractical", "bilateral", "filter", "can", "alternatively", "rephrase", "nearest", "neighbour", "search", "five", "dimension", "every", "-lrb-", "-rrb-", "point", "image", "we", "would", "like", "gather", "color", "from", "other", "nearby", "point", "suggest", "store", "cloud", "point", "represent", "image", "manifold", "kd-tree", "use", "approximate", "nearest", "neighbour", "query", "-lrb-", "describe", "-lsb-", "Arya", "et", "al.", "1998", "-rsb-", "-rrb-", "find", "nearby", "value", "unfortunately", "approach", "scale", "poorly", "filter", "size", "large", "filter", "each", "pixel", "may", "near", "every", "other", "pixel", "would", "preferable", "subsample", "set", "neighbour", "statistically", "efficient", "manner", "facilitate", "query", "we", "propose", "new", "type", "kd-tree", "which", "we", "term", "gaussian", "kd-tree", "describe", "section", "tree", "sparsely", "represent", "high-dimensional", "space", "value", "store", "point", "point", "cloud", "derive", "from", "reduce", "set", "pixel", "from", "original", "image", "so", "unlike", "bilateral", "grid", "we", "only", "ever", "store", "2d", "manifold", "regardless", "size", "dimensionality", "space", "which", "embedded", "tree", "support", "rapid", "montecarlo-sampled", "query", "probabilistically", "scatter", "gather", "from", "point", "use", "stratified", "weighted", "importance", "sampling", "query", "use", "implement", "embedding", "blur", "sampling", "space", "describe", "section", "do", "so", "computational", "complexity", "independent", "filter", "size", "linear", "dimensionality", "since", "gaussian", "kd-tree", "scale", "well", "dimension", "we", "need", "constrain", "ourselves", "three-dimensional", "color", "distance", "ability", "cheaply", "perform", "blur", "weight", "higher", "dimensional", "distance", "we", "can", "also", "accelerate", "non-local", "means", "-lsb-", "buade", "et", "al.", "2005", "-rsb-", "non-local", "means", "mix", "pixel", "value", "other", "pixel", "have", "similar", "local", "neighborhood", "equivalent", "gaussian", "blur", "2d", "manifold", "embed", "space", "much", "higher", "dimensionality", "non-local", "means", "usually", "make", "tractable", "limit", "only", "search", "similar", "neighborhood", "small", "local", "search", "window", "around", "each", "pixel", "we", "method", "fact", "slightly", "faster", "when", "search", "completely", "unbounded", "fewer", "dimension", "consider", "we", "discuss", "non-local", "means", "detail", "section", "3.2", "while", "non-local", "means", "increase", "number", "range", "dimension", "we", "can", "also", "increase", "number", "domain", "dimension", "include", "time", "section", "3.2", "we", "demonstrate", "fast", "non-local", "means", "denoise", "space-time", "volume", "non-local", "means", "able", "denoise", "dynamic", "scene", "average", "pixel", "value", "over", "time", "without", "require", "explicit", "motion", "model", "finally", "gaussian", "kd-tree", "do", "require", "any", "particular", "order", "structure", "value", "store", "value", "need", "lie", "grid", "we", "can", "mix", "they", "accord", "distance", "between", "any", "set", "associate", "vector", "we", "like", "we", "therefore", "need", "restrict", "ourselves", "image", "section", "3.3", "we", "apply", "non-local", "means", "noisy", "geometry", "we", "tree", "construction", "gaussian", "query", "algorithm", "dataparallel", "so", "we", "have", "also", "implement", "they", "graphic", "card", "use", "CUDA", "-lsb-", "Buck", "2007", "-rsb-", "significant", "speedup", "over", "CPU", "implementation", "implementation", "detail", "section", "2.4" ],
  "content" : "In recent years, a variety of related non-linear filters have become important for various tasks in image processing, computational photography, geometry processing, and related fields. These include the bilateral filter, the non-local means filter, and various similar ad-hoc filters used for particular applications. Such filters are often highly computationally intensive. We present a framework with which to understand such filters, and an acceleration data structure and algorithm that applies broadly across all of them. Let us begin with the simple case of a bilateral filter. Recent methods for accelerating the bilateral filter respect distance in space and in luminance. One such method, the bilateral grid [Paris and Durand 2006], does this by embedding the image as a two dimensional manifold in a coarsely voxelized three dimensional spaceluminance volume, performing a 3D Gaussian blur, and then sampling again along the image manifold to construct the output. A shortcoming of this technique, as well as other recent accelerations of the bilateral filter by [Durand and Dorsey 2002] and [Weiss 2006], is that they do not respect distance in chrominance, resulting in unwanted blurring of neighbouring isoluminant regions (Figure 2). One way to address this problem is to expand the bilateral grid to a 5D space-color volume, as described in [Paris and Durand 2009]. However, as we argue in Section 3.1, the memory required to represent the grid grows exponentially with the number of dimensions, as does the time required by each stage of the algorithm. This growth is manageable if the filter size in both space and color is large, which in turn permits the grid to be coarse. However, if the filter is small the grid must be fine, making the memory and time requirements of this approach impractical. Bilateral filtering can alternatively be rephrased as a nearest neighbour search in five dimensions. For every (x, y, r, g, b) point in the image, we would like to gather colors from other nearby points. This suggests storing the cloud of points representing the image manifold in a kd-tree, and using approximate nearest neighbour queries (as described by [Arya et al. 1998]) to find nearby values. Unfortunately this approach scales poorly with filter size. For a large filter each pixel may be near to every other pixel. It would be preferable to subsample this set of neighbours in a statistically efficient manner. To facilitate such queries, we propose a new type of kd-tree, which we term a Gaussian kd-tree, described in Section 2. The tree sparsely represents the high-dimensional space as values stored at points. This point cloud is derived from a reduced set of the pixels from the original image, so unlike the bilateral grid, we only ever store a 2D manifold, regardless of the size and dimensionality of the space in which it is embedded. The tree supports rapid MonteCarlo-sampled queries to probabilistically scatter to or gather from the points, using stratified weighted importance sampling. These queries are used to implement the embedding, blurring, and sampling of the space as described in Section 2, and they do so at a computational complexity independent of the filter size and linear in the dimensionality. Since the Gaussian kd-tree scales well with dimension, we need not constrain ourselves to three-dimensional color distances. With the ability to cheaply perform blurs weighted by higher dimensional distances, we can also accelerate non-local means [Buades et al. 2005]. Non-local means mixes pixel values with other pixels that have similar local neighborhoods, and is equivalent to a Gaussian blur on a 2D manifold embedded in a space of much higher dimensionality. Non-local means is usually made tractable by limiting it to only search for similar neighborhoods in a small local search window around each pixel. Our method is in fact slightly faster when the search is completely unbounded, as there are fewer dimensions to consider. We discuss non-local means in detail in Section 3.2. While non-local means increases the number of range dimensions, we can also increase the number of domain dimensions to include time. In Section 3.2, we demonstrate fast non-local means for denoising space-time volumes. Non-local means is able to denoise dynamic scenes by averaging pixel values over time without requiring an explicit motion model. Finally, the Gaussian kd-tree does not require any particular ordering or structure to the values it stores. The values need not lie on a grid, and we can mix them according to distances between any set of associated vectors we like. We therefore need not restrict ourselves to images. In Section 3.3 we apply non-local means to noisy geometry. Our tree construction and Gaussian query algorithms are dataparallel, and so we have also implemented them on a graphics card using CUDA [Buck 2007] for a significant speedup over the CPU implementation. Implementation details are in Section 2.4.",
  "resources" : [ ]
}