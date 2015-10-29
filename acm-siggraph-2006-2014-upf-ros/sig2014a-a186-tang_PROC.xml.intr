{
  "uri" : "sig2014a-a186-tang_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2014a/a186-tang_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Fast and Exact Continuous Collision Detection with Bernstein Sign Classification",
    "published" : "2014",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Dinesh-Manocha",
      "name" : "Dinesh",
      "surname" : "Manocha"
    } ]
  },
  "bagOfWords" : [ "problem", "fast", "reliable", "collision", "detection", "arise", "physically-based", "simulation", "geometric", "computing", "robotic", "many", "application", "require", "accurate", "algorithm", "do", "miss", "single", "collision", "maintain", "intersection-free", "mesh", "throughout", "simulation", "some", "widely-used", "algorithm", "contact", "computation", "base", "continuous", "collision", "detection", "-lrb-", "CCD", "-rrb-", "give", "two", "discrete", "instance", "configuration", "rigid", "deformable", "model", "CCD", "algorithm", "model", "motion", "each", "object", "mesh", "element", "use", "continuous", "trajectory", "between", "configuration", "check", "collision", "along", "trajectory", "algorithm", "widely", "use", "cloth", "simulation", "-lsb-", "Provot", "1997", "Bridson", "et", "al.", "2002", "Harmon", "et", "al.", "2008", "Brochu", "et", "al.", "2012", "-rsb-", "rigid-body", "simulation", "-lsb-", "Redon", "et", "al.", "2002", "-rsb-", "hair", "simulation", "-lsb-", "Selle", "et", "al.", "2008", "-rsb-", "FEM", "simulation", "-lsb-", "Tang", "et", "al.", "2011", "-rsb-", "robot", "motion", "planning", "-lsb-", "LaValle", "2006", "Tang", "et", "al.", "2010a", "-rsb-", "dynamic", "solver", "-lsb-", "Stam", "2009", "-rsb-", "etc.", "simplest", "algorithm", "triangular", "mesh", "linearly", "interpolate", "trajectory", "vertex", "case", "contact", "computation", "reduce", "perform", "series", "elementary", "test", "between", "vertex", "edge", "face", "use", "cubic", "polynomial", "root", "solver", "-lsb-", "Provot", "1997", "Bridson", "et", "al.", "2002", "-rsb-", "many", "high-level", "culling", "technique", "section", "we", "give", "brief", "overview", "prior", "work", "CCD", "algorithm", "high-level", "collision", "culling", "computation", "root", "polynomial", "many", "technique", "have", "be", "propose", "CCD", "between", "rigid", "model", "-lsb-", "Redon", "et", "al.", "2002", "Kim", "Rossignac", "2003", "-rsb-", "articulate", "model", "-lsb-", "Zhang", "et", "al.", "2007", "-rsb-", "deformable", "model", "-lsb-", "volino", "Thalmann", "1994", "Govindaraju", "et", "al.", "2005", "Hutter", "Fuhrmann", "2007", "Tang", "et", "al.", "2011", "-rsb-", "lowest", "level", "algorithm", "perform", "elementary", "test", "between", "triangle", "pair", "elementary", "test", "typically", "perform", "compute", "root", "cubic", "polynomial", "other", "CCD", "algorithm", "base", "conservative", "local", "advancement", "-lsb-", "Tang", "et", "al.", "2009b", "-rsb-", "all", "method", "prone", "floating-point", "error", "numerical", "tolerance", "therefore", "can", "result", "false", "negative", "false", "positive", "Wang", "-lsb-", "2014", "-rsb-", "have", "perform", "forward", "error", "analysis", "elementary", "test", "use", "analysis", "derive", "tight", "error", "bound", "floating-point", "computation", "use", "reduce", "number", "false", "positive", "contrast", "we", "bsc-exact", "algorithm", "approach", "describe", "-lsb-", "Brochu", "et", "al.", "2012", "-rsb-", "reliable", "tight", "error", "bound", "-lsb-", "Wang", "2014", "-rsb-", "can", "use", "derive", "tighter", "error", "bound", "bsc-float", "high-level", "Culling", "many", "high-level", "technique", "have", "be", "propose", "accelerate", "CCD", "computation", "reduce", "number", "elementary", "test", "between", "triangle", "pair", "remove", "redundant", "elementary", "test", "-lsb-", "Curtis", "et", "al.", "2008", "Tang", "et", "al.", "2009a", "Wong", "Baciu", "2006", "-rsb-", "simplest", "culling", "algorithm", "use", "bvh", "-lrb-", "bound", "volume", "hierarchy", "-rrb-", "base", "k-dop", "aabb", "other", "method", "use", "bound", "surface", "normal", "curvature", "-lsb-", "volino", "Thalmann", "1994", "Provot", "1997", "Mezger", "et", "al.", "2003", "-rsb-", "perform", "selfcollision", "culling", "-lsb-", "Schvartzman", "et", "al.", "2010", "Pabst", "et", "al.", "2010", "Zheng", "James", "2012", "-rsb-", "many", "algorithm", "implement", "use", "floating-point", "arithmetic", "operation", "prone", "numerical", "error", "polynomial", "root", "evaluation", "many", "numerical", "iterative", "method", "have", "be", "propose", "compute", "root", "polynomial", "equation", "tend", "use", "tolerance", "can", "result", "false", "positive", "false", "negative", "CCD", "computation", "computer", "graphic", "geometric", "modeling", "polynomial", "represent", "use", "spline", "basis", "root", "can", "compute", "use", "geometric", "subdivision", "method", "de", "casteljau?s", "algorithm", "-lsb-", "Farin", "2002", "-rsb-", "b?zier", "clipping", "-lsb-", "Sederberg", "Nishita", "1990", "-rsb-", "subdivision", "method", "implement", "use", "finite-precision", "arithmetic", "also", "prone", "roundoff", "error", "extensive", "literature", "symbolic", "computation", "computational", "geometry", "reliably", "compute", "root", "polynomial", "use", "exact", "arithmetic", "-lsb-", "yap", "2004", "Mourrain", "et", "al.", "2005", "-rsb-" ],
  "content" : "The problem of fast and reliable collision detection arises in physically-based simulation, geometric computing, and robotics. Many applications require accurate algorithms that do not miss a single collision and maintain intersection-free meshes throughout the simulation. Some of the widely-used algorithms for contact computation are based on continuous collision detection (CCD). Given two discrete instances or configurations of rigid or deformable models, CCD algorithms model the motion of each object or a mesh element using a continuous trajectory between the configurations and check for collisions along the trajectory. These algorithms are widely used for cloth simulation [Provot 1997; Bridson et al. 2002; Harmon et al. 2008; Brochu et al. 2012], rigid-body simulation [Redon et al. 2002], hair simulation [Selle et al. 2008], FEM simulation [Tang et al. 2011], robot motion planning [LaValle 2006; Tang et al. 2010a], dynamic solvers [Stam 2009], etc. The simplest algorithms for triangular meshes linearly interpolate the trajectories of the vertices. In this case, contact computation reduces to performing a series of elementary tests between the vertices, edges, and faces using cubic polynomial root solvers [Provot 1997; Bridson et al. 2002]. Many high-level culling techniques In this section, we give a brief overview of prior work on CCD algorithms, high-level collision culling, and the computation of the roots of polynomials. Many techniques have been proposed for CCD between rigid models [Redon et al. 2002; Kim and Rossignac 2003], articulated models [Zhang et al. 2007], and deformable models [Volino and Thalmann 1994; Govindaraju et al. 2005; Hutter and Fuhrmann 2007; Tang et al. 2011]. At the lowest level, these algorithms perform elementary tests between triangle pairs. The elementary tests are typically performed by computing roots of cubic polynomials. Other CCD algorithms are based on conservative local advancement [Tang et al. 2009b]. All these methods are prone to floating-point errors and numerical tolerances. Therefore, they can result in false negatives and false positives. Wang [2014] has performed forward error analysis for elementary tests and used that analysis to derive tight error bounds for floating-point computation. This is used to reduce the number of false positive. In contrast, our BSC-exact algorithm and the approach described in [Brochu et al. 2012] are reliable. The tight error bounds in [Wang 2014] can be used to derive tighter error bounds for BSC-float. High-level Culling: Many high-level techniques have been proposed to accelerate CCD computations by reducing the number of elementary tests between the triangle pairs, such as removing redundant elementary tests [Curtis et al. 2008; Tang et al. 2009a; Wong and Baciu 2006]. The simplest culling algorithms use BVHs (bounding volume hierarchies) based on k-DOPs or AABBs. Other methods use bounds on surface normals and curvature [Volino and Thalmann 1994; Provot 1997; Mezger et al. 2003] or perform selfcollision culling [Schvartzman et al. 2010; Pabst et al. 2010; Zheng and James 2012]. Many of these algorithms are implemented using floating-point arithmetic operations and are prone to numerical errors. Polynomial Root Evaluation: Many numerical iterative methods have been proposed to compute roots of polynomial equations. They tend to use tolerances and can result in false positives or false negatives for CCD computations. In computer graphics and geometric modeling, polynomials are represented using the spline basis, and their roots can be computed using the geometric subdivision methods, such as de Casteljau?s algorithm [Farin 2002] or B?zier clipping [Sederberg and Nishita 1990]. These subdivision methods are implemented using finite-precision arithmetic and are also prone to roundoff errors. There is extensive literature in symbolic computation and computational geometry on reliably computing the roots of polynomials using exact arithmetic [Yap 2004; Mourrain et al. 2005].",
  "resources" : [ ]
}