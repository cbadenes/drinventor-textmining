{
  "uri" : "sig2008a-a144-sander_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2008a/a144-sander_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Efficient Traversal of Mesh Edges using Adjacency Primitives",
    "published" : "2008",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Pedro V.-Sander",
      "name" : "Pedro V.",
      "surname" : "Sander"
    }, {
      "uri" : "http://drinventor/Diego-Nehab",
      "name" : "Diego",
      "surname" : "Nehab"
    }, {
      "uri" : "http://drinventor/Eden-Chlamtac",
      "name" : "Eden",
      "surname" : "Chlamtac"
    }, {
      "uri" : "http://drinventor/Hugues-Hoppe",
      "name" : "Hugues",
      "surname" : "Hoppe"
    } ]
  },
  "bagOfWords" : [ "triangle", "widespread", "rasterization", "primitive", "so", "large", "body", "work", "optimize", "traversal", "triangle", "mesh", "efficient", "render", "e.g.", "use", "triangle", "strip", "-lsb-", "Evans", "et", "al.", "1996", "Xiang", "et", "al.", "1999", "Estkowski", "et", "al.", "2002", "-rsb-", "manage", "vertex", "buffer", "-lsb-", "deer", "1995", "Chow", "1997", "-rsb-", "index", "strip", "vertex", "caching", "-lsb-", "hoppe", "1999", "Lin", "Yu", "2006", "Sander", "et", "al.", "2007", "Chhugani", "Kumar", "2007", "-rsb-", "particular", "current", "gpus", "include", "vertex", "cache", "al", "low", "reuse", "post-shaded", "vertex", "among", "several", "adjacent", "triangle", "thereby", "achieve", "significant", "reduction", "both", "memory", "bandwidth", "vertex", "shader", "computation", "many", "advanced", "rendering", "technique", "process", "only", "mesh", "face", "also", "mesh", "edge", "application", "include", "shadow", "volume", "-lsb-", "Crow", "1977", "-rsb-", "silhouette", "render", "-lsb-", "Hertzmann", "1999", "Gooch", "Gooch", "2001", "-rsb-", "motion", "blur", "-lsb-", "wloka", "Zeleznik", "1996", "-rsb-", "fur", "rendering", "-lsb-", "Lengyel", "et", "al.", "2001", "-rsb-", "wireframe", "rendering", "most", "technique", "process", "edge", "require", "access", "its", "two", "adjacent", "face", "have", "motivate", "introduction", "adjacency", "primitive", "latest", "graphic", "system", "-lsb-", "Blythe", "2006", "-rsb-", "primitive", "process", "new", "programmable", "unit", "graphic", "pipeline", "geometry", "shader", "which", "read", "primitive", "perform", "computation", "emit", "variable", "number", "new", "primitive", "paper", "we", "present", "general", "scheme", "optimize", "traversal", "mesh", "efficient", "GPU", "processing", "its", "edge", "we", "knowledge", "first", "attempt", "optimization", "some", "graphic", "application", "require", "traversal", "triangle", "addition", "edge", "we", "explore", "how", "can", "achieve", "efficiently", "same", "traversal", "pass", "separate", "pass", "use", "same", "vertex", "index", "buffer", "approach", "we", "basic", "strategy", "traverse", "mesh", "use", "list", "triangle-with-adjacency", "primitive", "show", "Figure", "2a", "each", "primitive", "use", "index", "encode", "central", "cover", "face", "well", "its", "adjacent", "face", "principle", "primitive", "permit", "processing", "cover", "face", "itself", "all", "its", "edge", "all", "its", "adjacent", "face", "we", "goal", "process", "all", "mesh", "edge", "triangle", "exactly", "once", "use", "same", "list", "primitive", "while", "keep", "overall", "number", "primitive", "minimum", "because", "geometry", "shader", "consider", "many", "primitive", "simultaneously", "simd", "parallelism", "GPU", "crucial", "computational", "efficiency", "processing", "each", "primitive", "require", "same", "sequence", "step", "maximize", "simd", "efficiency", "we", "allow", "each", "adjacency", "primitive", "process", "face", "time", "-lrb-", "figure", "2a", "-rrb-", "central", "cover", "face", "optional", "adjacent", "face", "we", "refer", "assign", "face", "further", "improve", "simd", "parallelism", "we", "place", "some", "restriction", "selection", "assign", "face", "discuss", "section", "note", "regular", "mesh", "region", "all", "edge", "face", "can", "cover", "introduce", "primitive", "only", "half", "triangle", "i.e.", "all", "face", "point", "same", "direction", "-lrb-", "figure", "2b", "-rrb-", "each", "one", "assign", "face", "point", "opposite", "direction", "other", "hand", "around", "any", "irregular", "vertex", "odd", "degree", "least", "one", "edge", "must", "cover", "twice", "therefore", "some", "redundancy", "inevitable", "-lrb-", "figure", "2c", "-rrb-", "nevertheless", "because", "most", "triangles-with-adjacency", "primitive", "encode", "two", "face", "index", "buffer", "contain", "only", "about", "index", "per", "mesh", "triangle", "-lrb-", "one", "primitive", "every", "mesh", "triangle", "index", "per", "primitive", "-rrb-", "therefore", "have", "approximately", "same", "memory", "cost", "widely", "use", "index", "triangle", "list", "representation", "algorithm", "overview", "problem", "we", "face", "can", "formulate", "graph", "theoretical", "problem", "dual", "graph", "induce", "triangle", "mesh", "particular", "we", "show", "select", "minimum", "number", "primitive", "cover", "all", "edge", "reduce", "minimum", "vertex", "cover", "problem", "assign", "remain", "face", "primitive", "reduce", "two", "bipartite", "matching", "problem", "we", "algorithm", "have", "three", "major", "step", "show", "Figure", "vertex", "cover", "problem", "np-complete", "fortunately", "we", "particular", "setting", "we", "can", "rely", "fast", "approximation", "use", "stochastic", "algorithm", "moreover", "derive", "good", "lower", "bind", "number", "cover", "face", "we", "able", "show", "practical", "triangle", "mesh", "approximate", "solution", "within", "few", "percent", "optimal", "face", "assignment", "problem", "reduce", "two", "bipartite", "matching", "problem", "can", "therefore", "solve", "quickly", "-lrb-", "1.5", "-rrb-", "time", "e.g.", "only", "sec", "mesh", "75,000", "vertex", "particular", "we", "prove", "surprising", "result", "perfect", "matching", "guarantee", "exist", "even", "add", "restriction", "introduce", "simd", "efficiency", "have", "determine", "set", "triangles-with-adjacency", "we", "optimize", "order", "maximize", "vertex", "cache", "reuse", "cover", "assignment", "problem", "always", "solve", "offline", "preprocess", "because", "order", "efficiency", "depend", "cache", "size", "we", "provide", "two", "order", "algorithm", "slower", "careful", "scheme", "assume", "prior", "knowledge", "cache", "size", "faster", "scheme", "can", "run", "load", "time", "base", "specific", "hardware", "optimize", "traversal", "mesh", "edge", "GPU", "relatively", "unexplored", "area", "one", "prior", "technique", "compute", "shadow", "volume", "entirely", "GPU", "introduce", "degenerate", "quadrilateral", "each", "edge", "input", "mesh", "selectively", "translate", "vertex", "expand", "fraction", "degenerate", "face", "form", "side", "shadow", "volume", "-lsb-", "Brennan", "2002", "-rsb-", "however", "technique", "require", "splitting", "mesh", "vertex", "preprocess", "result", "mesh", "time", "large", "original", "some", "related", "technique", "GPU", "rendering", "silhouette", "fin", "also", "introduce", "degenerate", "quadrilateral", "edge", "-lsb-", "card", "Mitchell", "2002", "McGuire", "Hughes", "2004", "-rsb-", "therefore", "also", "require", "memory", "buffer", "many", "additional", "vertex", "face", "several", "sample", "program", "demonstrate", "application", "new", "triangle-with-adjacency", "primitive", "-lsb-", "Microsoft", "Corp", "2007", "Tariq", "2007", "-rsb-", "basic", "approach", "all", "program", "instantiate", "primitive", "each", "input", "triangle", "avoid", "processing", "interior", "edge", "twice", "test", "perform", "geometry", "shader", "appropriately", "skip", "half", "edge", "test", "base", "either", "triangle", "orientation", "silhouette", "per-edge", "order", "vertex", "index", "note", "local", "branch", "lead", "inefficient", "simd", "processing", "contrast", "we", "scheme", "generate", "roughly", "half", "many", "primitive", "moreover", "most", "primitive", "process", "all", "adjacent", "edge", "result", "excellent", "simd", "utilization", "prove", "-lrb-", "-rrb-", "note", "contain", "cycle", "-lrb-", "removal", "preserve", "odd", "join", "-rrb-", "thus", "forest", "i.e.", "vertex-disjoint", "union", "tree", "each", "tree", "we", "find", "legal", "path", "decomposition", "repeatedly", "perform", "following", "contract", "all", "uninterrupted", "path", "individual", "edge", "choose", "lowest", "leaf", "match", "its", "sibling", "remove", "connect", "path", "prove", "-lrb-", "-rrb-", "note", "any", "matching", "total", "length", "all", "shortest", "path", "minimal", "path", "must", "edge-disjoint", "thus", "union", "all", "path", "indeed", "odd", "join", "we", "must", "show", "some", "minimal", "odd", "join", "odd", "connect", "legal", "path", "also", "connect", "illegal", "shortest", "path", "we", "two", "crucial", "observation", "which", "follow", "from", "minimality" ],
  "content" : "Triangles are a widespread rasterization primitive, so there is a large body of work on optimizing the traversal of triangle meshes for efficient rendering, e.g. using triangle strips [Evans et al. 1996; Xiang et al. 1999; Estkowski et al. 2002], managed vertex buffers [Deering 1995; Chow 1997], and indexed strips with vertex caching [Hoppe 1999; Lin and Yu 2006; Sander et al. 2007; Chhugani and Kumar 2007]. In particular, current GPUs include a vertex cache to al low reuse of post-shaded vertices among several adjacent triangles, thereby achieving significant reduction in both memory bandwidth and vertex shader computation. Many advanced rendering techniques process not only mesh faces but also mesh edges. Applications include shadow volumes [Crow 1977], silhouette rendering [Hertzmann 1999; Gooch and Gooch 2001], motion blur [Wloka and Zeleznik 1996], fur rendering [Lengyel et al. 2001], and wireframe rendering. In most techniques, processing an edge requires access to its two adjacent faces. This has motivated the introduction of adjacency primitives in the latest graphics systems [Blythe 2006]. The primitives are processed in a new programmable unit of the graphics pipeline, the geometry shader, which reads a primitive, performs computation, and emits a variable number of new primitives. In this paper, we present a general scheme that optimizes the traversal of a mesh for efficient GPU processing of its edges. To our knowledge, this is the first attempt at such an optimization. Some graphics applications require traversal of triangles in addition to edges, and we explore how this can be achieved efficiently in the same traversal pass, or in separate passes using the same vertex and index buffers. Approach Our basic strategy is to traverse the mesh using a list of triangle-with-adjacency primitives. As shown in Figure 2a , each such primitive uses 6 indices to encode a central cover face as well as its 3 adjacent faces. In principle, the primitive permits the processing of the cover face itself, all its 3 edges, and all its 3 adjacent faces. Our goal is to process all mesh edges and triangles exactly once, using the same list of primitives, while keeping the overall number of primitives to a minimum. Because the geometry shaders consider many primitives simultaneously with SIMD parallelism on the GPU, it is crucial for computational efficiency that processing each primitive requires the same sequence of steps. To maximize this SIMD efficiency, we allow each adjacency primitive to process 1 or 2 faces at a time (Figure 2a): the central cover face, and an optional adjacent face that we refer to as the assigned face. To further improve SIMD parallelism, we place some restrictions on the selection of assigned faces, as discussed in Section 5. Note that, in regular mesh regions, all edges and faces can be covered by introducing primitives for only half of the triangles, i.e. all the faces ?pointing in the same direction? ( Figure 2b ), each one assigned to a face pointing in the opposite direction. On the other hand, around any irregular vertex of odd degree, at least one edge must be covered twice, and therefore some redundancy is inevitable ( Figure 2c ). Nevertheless, because most triangles-with-adjacency primitives encode two faces, the index buffer contains only about 3 indices per mesh triangle (one primitive for every 2 mesh triangles, 6 indices per primitive), and therefore has approximately the same memory cost as the widely used indexed triangle list representation. Algorithm overview The problems we face can be formulated as graph theoretical problems on the dual graph induced by the triangle mesh. In particular, we show that selecting a minimum number of primitives to cover all edges reduces to a minimum vertex cover problem, and that assigning the remaining faces to these primitives reduces to two bipartite matching problems. Our algorithm has three major steps, as shown in Figure 1 : 1. The vertex cover problem is NP-complete, but fortunately in our particular setting we can rely on a fast approximation using a stochastic algorithm. Moreover, by deriving a good lower bound on the number of cover faces, we are able to show that, for practical triangle meshes, the approximate solutions are within a few percent of optimal; 2. The face assignment problem reduces to two bipartite matching problems, and can therefore be solved quickly in O(n 1.5 ) time; e.g. only 4 sec for a mesh with n = 75,000 vertices. In particular, we prove the surprising result that perfect matchings are guaranteed to exist, even with the added restrictions introduced for SIMD efficiency; 3. Having determined a set of triangles-with-adjacency, we optimize their ordering to maximize vertex cache reuse. The cover and assignment problems are always solved in an offline preprocess. Because ordering efficiency depends on cache size, we provide two ordering algorithms: a slower, careful scheme that assumes prior knowledge of the cache size, and a faster scheme that can be run at load time based on the specific hardware. Optimizing the traversal of mesh edges on the GPU is a relatively unexplored area. One prior technique for computing shadow volumes entirely on the GPU is to introduce a degenerate quadrilateral on each edge of the input mesh, and to selectively translate vertices to expand a fraction of these degenerate faces to form the sides of the shadow volume [Brennan 2002]. However, the technique requires splitting the mesh vertices in a preprocess, resulting in a mesh that is 6 times as large as the original. Some related techniques for GPU rendering of silhouettes or fins also introduce degenerate quadrilaterals on edges [Card and Mitchell 2002; McGuire and Hughes 2004], and therefore also require memory buffers with many additional vertices and faces. Several sample programs demonstrate applications of the new triangle-with-adjacency primitive [Microsoft Corp 2007; Tariq 2007]. The basic approach in all these programs is to instantiate a primitive for each input triangle. To avoid processing interior edges twice, a test is performed in the geometry shader to appropriately skip half of the edges. This test is based either on the triangle orientation at silhouettes, or on per-edge ordering of vertex indices. Note that such local branching leads to inefficient SIMD processing. In contrast, our scheme generates roughly half as many primitives, and moreover most of these primitives process all 3 of their adjacent edges, resulting in excellent SIMD utilization. To prove (1), note that G  ? contains no cycles (their removal preserves a V odd -join). Thus, G  ? is a forest, i.e. a vertex-disjoint union of trees. For each such tree T , we find a legal path decomposition by repeatedly performing the following: Contract all uninterrupted paths in T to individual edges. Choose a lowest leaf and match it to its sibling, removing the connecting path in T . To prove (2), note that for any such matching, if the total length of all shortest paths is minimal, the paths must be edge-disjoint. Thus, the union of all paths is indeed a V odd -join. We must show that for some minimal V odd -join E,  ? no u, v ? V odd connected by a legal path in E  ? are also connected by an illegal shortest path. We start with two crucial observations, which follow from the minimality of E:  ?",
  "resources" : [ ]
}