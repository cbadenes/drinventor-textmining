{
  "uri" : "sig2010a-a145-farbman_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2010a/a145-farbman_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Diffusion Maps for Edge-Aware Image Editing",
    "published" : "2010",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Zeev-Farbman",
      "name" : "Zeev",
      "surname" : "Farbman"
    }, {
      "uri" : "http://drinventor/Raanan-Fattal",
      "name" : "Raanan",
      "surname" : "Fattal"
    }, {
      "uri" : "http://drinventor/Dani-Lischinski",
      "name" : "Dani",
      "surname" : "Lischinski"
    } ]
  },
  "bagOfWords" : [ "edge-aware", "operation", "edge-preserving", "smoothing", "edge-aware", "interpolation", "have", "recently", "emerge", "useful", "tool", "variety", "image", "editing", "manipulation", "task", "edge-preserving", "smoothing", "operator", "widely", "use", "extract", "and/or", "remove", "detail", "from", "image", "e.g.", "-lsb-", "Chen", "et", "al.", "2007", "Farbman", "et", "al.", "2008", "Subr", "et", "al.", "2009", "-rsb-", "edge-aware", "interpolation", "make", "possible", "propagate", "set", "sparse", "user-specified", "constraint", "-lrb-", "edit", "-rrb-", "intuitive", "manner", "account", "strong", "edge", "image", "e.g.", "-lsb-", "Levin", "et", "al.", "2004", "Lischinski", "et", "al.", "2006", "Yatziv", "Sapiro", "2006", "Li", "et", "al.", "2008", "-rsb-", "most", "edge-aware", "interpolation", "approach", "base", "local", "propagation", "sparse", "user", "constraint", "use", "affinity", "between", "adjacent", "pixel", "formulate", "solve", "optimization", "problem", "-lsb-", "Levin", "et", "al.", "2004", "-rsb-", "perform", "blend", "use", "intrinsic", "-lrb-", "geodesic", "-rrb-", "distance", "-lsb-", "Yatziv", "Sapiro", "2006", "-rsb-", "while", "approach", "provide", "user", "good", "local", "control", "have", "difficulty", "propagate", "sparse", "edit", "across", "strongly", "textured", "region", "-lrb-", "figure", "top", "row", "-rrb-", "can?t", "handle", "fragmented", "region", "several", "solution", "have", "be", "recently", "propose", "address", "issue", "particular", "global", "all-pairs", "approach", "-lsb-", "Pellacini", "2008", "-rsb-", "demonstrate", "well-suited", "propagate", "sparse", "-lrb-", "possibly", "rough", "-rrb-", "user", "edit", "large", "spatial", "neighborhood", "we", "discuss", "all", "approach", "more", "detail", "next", "section", "work", "we", "improve", "performance", "exist", "edge-aware", "edge-aware", "interpolation", "number", "technique", "edgeaware", "interpolation", "have", "be", "recently", "explore", "Levin", "et", "al.", "-lsb-", "2004", "-rsb-", "introduce", "optimization", "framework", "colorize", "grayscale", "image", "propagation", "from", "set", "sparse", "user-provided", "constraint", "approach", "generalize", "other", "tonal", "manipulation", "-lsb-", "Lischinski", "et", "al.", "2006", "-rsb-", "well", "natural", "image", "matting", "-lsb-", "Levin", "et", "al.", "2008a", "-rsb-", "Yatziv", "Sapiro", "-lsb-", "2006", "-rsb-", "propagate", "similar", "constraint", "intrinsic", "-lrb-", "geodesic", "-rrb-", "distance", "base", "blending", "all", "technique", "above", "rely", "gradient", "between", "adjacent", "pixel", "control", "propagation", "thus", "have", "trouble", "propagate", "information", "highly", "textured", "region", "well", "prevent", "propagation", "across", "low-contrast", "edge", "handle", "fragmented", "-lrb-", "disconnect", "-rrb-", "region", "another", "problem", "since", "might", "require", "many", "constraint", "provide", "user", "Pellacini", "-lsb-", "2008", "-rsb-", "generalize", "optimization-based", "edit", "propagation", "consider", "interaction", "between", "all", "pair", "pixel", "image", "enable", "less", "precise", "specification", "user", "constraint", "propagation", "across", "disconnect", "region", "approach", "result", "large", "dense", "affinity", "matrix", "matrix", "approximately", "low-rank", "can", "approximate", "sampling", "just", "small", "number", "column", "-lrb-", "nystr?m", "method", "-rrb-", "-lsb-", "Williams", "Seeger", "2000", "-rsb-", "Xu", "et", "al.", "-lsb-", "2009", "-rsb-", "have", "recently", "propose", "accelerate", "all-pairs", "approach", "further", "compute", "propagation", "between", "pair", "cluster", "feature", "space", "rather", "than", "between", "pair", "pixel", "pellacini?s", "error", "analysis", "show", "nystr?m", "approximation", "become", "less", "accurate", "spatial", "range", "interaction", "decrease", "however", "since", "goal", "enable", "edit", "propagation", "rather", "large", "spatial", "neighborhood", "be", "able", "achieve", "satisfactory", "result", "use", "constant", "number", "sample", "-lrb-", "100", "-rrb-", "we", "work", "we", "also", "apply", "nystr?m", "method", "related", "eigenvalue", "problem", "-lsb-", "Fowlkes", "et", "al.", "2004", "-rsb-", "present", "refined", "error", "analysis", "more", "precisely", "quantify", "effective", "rank", "affinity", "matrix", "function", "spatial", "interaction", "range", "enable", "we", "generalize", "all-pairs", "approach", "handle", "arbitrary", "interaction", "range", "accurately", "efficiently", "ScribbleBoost", "-lsb-", "Li", "et", "al.", "2008", "-rsb-", "another", "approach", "improve", "propagation", "across", "textured", "fragmented", "region", "user?s", "scribble", "use", "perform", "supervised", "classification", "pixel", "result", "introduce", "optimization", "additional", "soft", "constraint", "selection", "mask", "compute", "solve", "linear", "system", "once", "each", "scribble", "type", "while", "we", "idea", "use", "diffusion", "distance", "also", "leverage", "machine", "learning", "technique", "we", "effectively", "perform", "unsupervised", "clustering", "which", "consider", "all", "datum", "image", "rather", "than", "just", "pixel", "cover", "particular", "set", "stroke", "furthermore", "result", "diffusion", "distance", "useful", "application", "edge-preserving", "smoothing", "where", "user", "input", "available", "edge-preserving", "smoothing", "edge-preserving", "smoothing", "use", "wide", "variety", "computational", "photography", "application", "-lsb-", "Farbman", "et", "al.", "2008", "-rsb-", "Popular", "edge-preserving", "smoothing", "filter", "include", "bilateral", "filter", "-lsb-", "tomasus", "Manduchi", "1998", "-rsb-", "which", "number", "efficient", "implementation", "have", "be", "propose", "-lsb-", "Durand", "Dorsey", "2002", "Paris", "Durand", "2006", "Chen", "et", "al.", "2007", "-rsb-", "fattal", "-lsb-", "2007", "-rsb-", "explore", "fast", "iterative", "multiscale", "variant", "bilateral", "filter", "while", "Farbman", "et", "al.", "-lsb-", "2008", "-rsb-", "advocate", "use", "weighted", "least", "square", "optimization", "instead", "recently", "fattal", "-lsb-", "2009", "-rsb-", "introduce", "edge-avoiding", "wavelet", "demonstrate", "usefulness", "very", "fast", "edge-preserving", "smoothing", "well", "edge-aware", "editing", "technique", "can", "also", "apply", "edit", "propagation", "via", "interactive", "painting", "edge-aware", "brush", "-lsb-", "Chen", "et", "al.", "2007", "-rsb-", "fast", "edge-aware", "push", "pull", "sparse", "constraint", "-lsb-", "fattal", "2009", "-rsb-", "all", "technique", "mention", "above", "rely", "difference", "between", "pixel", "value", "-lrb-", "difference", "luminance", "euclidean", "distance", "some", "color", "space", "-rrb-", "thus", "we", "argue", "could", "all", "benefit", "from", "use", "diffusion", "distance", "instead", "support", "we", "claim", "number", "example", "section", "anisotropic", "diffusion", "-lsb-", "Perona", "Malik", "1990", "Black", "et", "al.", "1998", "-rsb-", "another", "popular", "approach", "edge-preserving", "smoothing", "via", "nonlinear", "pde-based", "filter", "although", "we", "work", "employe", "similar", "terminology", "-lrb-", "i.e.", "diffusion", "time", "-rrb-", "we", "focus", "unsupervised", "preconditioning", "datum", "independent", "particular", "smoothing", "propagation", "scheme", "although", "explore", "paper", "one", "could", "conceivably", "use", "result", "diffusion", "distance", "computation", "edge-stopping", "term", "various", "anisotropic", "diffusion", "scheme", "Subr", "et", "al.", "-lsb-", "2009", "-rsb-", "have", "recently", "propose", "edge-preserving", "smoothing", "approach", "base", "identify", "fitting", "envelope", "local", "extrema", "image", "approach", "effectively", "assume", "oscillatory", "model", "textured", "region", "succeed", "remove", "detail", "even", "high-contrast", "textured", "region", "while", "we", "approach", "do", "make", "use", "texture", "model", "we", "show", "plug", "diffusion", "distance", "exist", "edge-preserving", "smoothing", "approach", "become", "possible", "remove", "detail", "just", "effectively", "scale", "detail", "remove", "may", "control", "via", "time", "parameter", "which", "build", "diffusion", "distance", "we", "use", "clustering", "Diffusion", "map", "have", "emerge", "machine", "learn", "community", "tool", "dimensionality", "reduction", "unsupervised", "clustering", "-lsb-", "coifman", "Lafon", "2006", "Nadler", "et", "al.", "2005", "Singer", "et", "al.", "2009", "-rsb-", "tool", "belong", "larger", "family", "spectral", "clustering", "technique", "which", "include", "other", "closely", "related", "method", "locally-linear", "embedding", "-lrb-", "lle", "-rrb-", "-lsb-", "Roweis", "Saul", "2000", "-rsb-", "isomaps", "-lsb-", "Tenenbaum", "et", "al.", "2000", "-rsb-", "laplacian", "eigenmap", "-lsb-", "Belkin", "Niyogi", "2003", "-rsb-", "particular", "spectral", "clustering", "method", "have", "be", "use", "perform", "hard", "-lrb-", "binary", "-rrb-", "segmentation", "-lsb-", "shus", "Malik", "1997", "Weiss", "1999", "-rsb-", "threshold", "eigenvector", "suitably", "form", "matrix", "Meila", "Shi", "-lsb-", "2001", "-rsb-", "point", "out", "connection", "between", "method", "Markov", "random", "walk", "Diffusion", "distance", "also", "have", "random", "walker", "interpretation", "-lrb-", "section", "3.1", "-rrb-", "however", "contrast", "method", "we", "interested", "hard", "segmentation", "rather", "derive", "new", "distance", "assist", "edgeaware", "interpolation", "smoothing", "use", "random", "walk", "segmentation", "also", "explore", "Grady", "-lsb-", "2006", "-rsb-", "he", "formulation", "yield", "linear", "system", "define", "inhomogeneous", "laplacian", "matrix", "similar", "one", "arise", "optimization-based", "edit", "propagation", "recently", "Grady", "suggest", "accelerate", "he", "segmentation", "approach", "precompute", "small", "number", "-lrb-", "40", "80", "-rrb-", "eigenvector", "-lsb-", "Grady", "Sinop", "2008", "-rsb-", "however", "since", "he", "random", "walker", "formulation", "consider", "only", "limited", "spatial", "neighborhood", "we", "analysis", "section", "imply", "approximation", "only", "accurate", "small", "image", "spectral", "clustering", "have", "also", "be", "use", "natural", "image", "matting", "-lsb-", "Levin", "et", "al.", "2008b", "-rsb-", "where", "eigenvector", "suitable", "laplacian", "matrix", "rotate", "combine", "together", "yield", "soft", "matte", "we", "also", "compute", "eigenvector", "use", "they", "order", "define", "robust", "distance", "between", "pair", "image", "pixel", "another", "family", "relevant", "work", "from", "computer", "vision", "literature", "path-based", "clustering", "method", "which", "examine", "distribution", "datum", "some", "-lrb-", "typically", "high-dimensional", "-rrb-", "feature", "space", "e.g.", "-lsb-", "Fischer", "Buhmann", "2003", "Chang", "Yeung", "2008", "-rsb-", "particular", "Omer", "Werman", "-lsb-", "2006", "-rsb-", "measure", "affinity", "between", "pixel", "term", "length", "density", "path", "connect", "they", "color", "space", "all", "method", "however", "very", "costly", "compute", "Diffusion", "distance", "also", "account", "length", "density", "path", "datum", "lend", "themselves", "faster", "computation", "addition", "diffusion", "map", "have", "built-in", "notion", "time", "which", "make", "possible", "control", "granularity", "-lrb-", "scale", "-rrb-", "cluster", "efficient", "intuitive", "manner" ],
  "content" : "Edge-aware operations, such as edge-preserving smoothing and edge-aware interpolation have recently emerged as useful tools for a variety of image editing and manipulation tasks: edge-preserving smoothing operators are widely used to extract and/or remove details from an image, e.g., [Chen et al. 2007; Farbman et al. 2008; Subr et al. 2009]; edge-aware interpolation makes it possible to propagate a set of sparse user-specified constraints (edits) in an intuitive manner by accounting for strong edges in the image, e.g., [Levin et al. 2004; Lischinski et al. 2006; Yatziv and Sapiro 2006; Li et al. 2008]. Most edge-aware interpolation approaches are based on local propagation of sparse user constraints. They use affinities between adjacent pixels to formulate and solve an optimization problem [Levin et al. 2004], or to perform blending using intrinsic (geodesic) distances [Yatziv and Sapiro 2006]. While such approaches provide the user with good local control, they have difficulty propagating sparse edits across strongly textured regions ( Figure 1 , top row), and can?t handle fragmented regions. Several solutions have been recently proposed to address these issues. In particular, the global all-pairs approach [An and Pellacini 2008] was demonstrated to be well-suited for propagating sparse (and possibly rough) user edits to large spatial neighborhoods. We discuss all these approaches in more detail in the next section. In this work we improve the performance of existing edge-aware Edge-aware interpolation. A number of techniques for edgeaware interpolation have been recently explored. Levin et al. [2004] introduced an optimization framework for colorizing grayscale images by propagation from a set of sparse user-provided constraints. This approach was generalized to other tonal manipulations [Lischinski et al. 2006], as well as to natural image matting [Levin et al. 2008a]. Yatziv and Sapiro [2006] propagate similar constraints by intrinsic (geodesic) distance based blending. All of the techniques above rely on gradients between adjacent pixels to control propagation, and thus have trouble propagating information in highly textured regions, as well as preventing propagation across low-contrast edges. Handling fragmented (disconnected) regions is another problem, since they might require many constraints to be provided by the user. An and Pellacini [2008] generalized optimization-based edit propagation to consider interactions between all pairs of pixels in the image, enabling less precise specification of user constraints and their propagation across disconnected regions. This approach results in a large dense affinity matrix, but this matrix is approximately low-rank, and can be approximated by sampling just a small number of columns (Nystr?m method) [Williams and Seeger 2000]. Xu et al. [2009] have recently proposed to accelerate the all-pairs approach further by computing the propagation between pairs of clusters in feature space, rather than between pairs of pixels. An and Pellacini?s error analysis shows that the Nystr?m approximation becomes less accurate as the spatial range of the interactions is decreased. However, since their goal is to enable edit propagation to rather large spatial neighborhood, they were able to achieve satisfactory results using a constant number of samples (100). In our work we also apply the Nystr?m method to a related eigenvalue problem [Fowlkes et al. 2004], and present a refined error analysis that more precisely quantifies the effective rank of the affinity matrix as a function of the spatial interaction range, enabling us to generalize the all-pairs approach to handle arbitrary interaction ranges accurately and efficiently. ScribbleBoost [Li et al. 2008] is another approach that improves propagation across textured or fragmented regions. The user?s scribbles are used to perform supervised classification of the pixels, and the results are introduced into the optimization as additional soft constraints. A selection mask is then computed by solving the linear system once for each scribble type. While our idea of using diffusion distances also leverages machine learning techniques, we effectively perform unsupervised clustering, which considers all of the data in the image, rather than just the pixels covered by a particular set of strokes. Furthermore, the resulting diffusion distances are useful in such applications as edge-preserving smoothing, where no user input is available. Edge-preserving smoothing. Edge-preserving smoothing is used in a wide variety of computational photography applications [Farbman et al. 2008]. Popular edge-preserving smoothing filters include the bilateral filter [Tomasi and Manduchi 1998], for which a number of efficient implementations have been proposed [Durand and Dorsey 2002; Paris and Durand 2006; Chen et al. 2007]. Fattal [2007] explored a fast iterative multiscale variant of the bilateral filter, while Farbman et al. [2008] advocated the use of weighted least squares optimization instead. Recently, Fattal [2009] introduced edge-avoiding wavelets, and demonstrated their usefulness for very fast edge-preserving smoothing, as well as for edge-aware editing. These techniques can also be applied to edit propagation, via interactive painting with edge-aware brushes [Chen et al. 2007], or by fast edge-aware pushing and pulling of the sparse constraints [Fattal 2009]. All of the techniques mentioned above rely on the difference between pixel values (difference in luminance, or Euclidean distance in some color space). Thus, we argue that they could all benefit from using diffusion distances instead, and support our claim by a number of examples in Section 4. Anisotropic diffusion [Perona and Malik 1990; Black et al. 1998] is another popular approach for edge-preserving smoothing via nonlinear PDE-based filtering. Although our work employes similar terminology (i.e., diffusion and time), our focus is on the unsupervised preconditioning of the data, independent of a particular smoothing or propagation scheme. Although not explored in this paper, one could conceivably use the resulting diffusion distances in the computation of the edge-stopping term of various anisotropic diffusion schemes. Subr et al. [2009] have recently proposed an edge-preserving smoothing approach based on identifying and fitting envelopes to local extrema in the image. This approach effectively assumes an oscillatory model of textured regions, and succeeds in removing detail even in high-contrast textured regions. While our approach does not make use of such a texture model, we show that by plugging diffusion distances into an existing edge-preserving smoothing approach it becomes possible to remove detail just as effectively. The scale of the details to be removed may be controlled via the time parameter, which is built into the diffusion distances that we use. Clustering. Diffusion maps have emerged in the machine learning community as a tool for dimensionality reduction and unsupervised clustering [Coifman and Lafon 2006; Nadler et al. 2005; Singer et al. 2009]. This tool belongs to a larger family of spectral clustering techniques, which includes other closely related methods, such as locally-linear embeddings (LLE) [Roweis and Saul 2000], Isomaps [Tenenbaum et al. 2000], and Laplacian eigenmaps [Belkin and Niyogi 2003]. In particular, spectral clustering methods have been used to perform hard (binary) segmentation [Shi and Malik 1997; Weiss 1999] by thresholding the eigenvectors of suitably formed matrices. Meila and Shi [2001] pointed out the connection between these methods and Markov random walks. Diffusion distances also have a random walker interpretation (Section 3.1). However, in contrast to these methods, we are not interested in hard segmentation, but rather in deriving new distances to assist in edgeaware interpolation and smoothing. The use of random walks for segmentation was also explored by Grady [2006]. His formulation yields a linear system defined by an inhomogeneous Laplacian matrix, similar to the ones that arise in optimization-based edit propagation. Recently Grady suggested to accelerate his segmentation approach by precomputing a small number (40?80) of eigenvectors [Grady and Sinop 2008]. However, since his random walker formulation considers only limited spatial neighborhoods, our analysis in Section 5 implies that such an approximation is only accurate for small images. Spectral clustering has also been used for natural image matting [Levin et al. 2008b], where the eigenvectors of a suitable Laplacian matrix are rotated and combined together to yield a soft matte. We also compute eigenvectors, but use them in order to define robust distances between pairs of image pixels. Another family of relevant works from the computer vision literature are path-based clustering methods, which examine the distribution of the data in some (typically high-dimensional) feature space, e.g., [Fischer and Buhmann 2003; Chang and Yeung 2008]. In particular, Omer and Werman [2006] measure the affinity between pixels in terms of the length and the density of the paths connecting them in color space. All of these methods, however, are very costly to compute. Diffusion distances also account for length and density of paths in the data, but lend themselves to faster computation. In addition, diffusion maps have a built-in notion of time, which makes it possible to control the granularity (scale) of the clusters in an efficient and intuitive manner.",
  "resources" : [ ]
}