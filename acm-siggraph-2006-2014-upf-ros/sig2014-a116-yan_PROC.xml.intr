{
  "uri" : "sig2014-a116-yan_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2014/a116-yan_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Rendering Glints on High-Resolution Normal-Mapped Specular Surfaces",
    "published" : "2014",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Ling-Qi-Yan",
      "name" : "Ling-Qi",
      "surname" : "Yan"
    }, {
      "uri" : "http://drinventor/Milo\\v{s}-Ha\\v{s}an",
      "name" : "Milo\\v{s}",
      "surname" : "Ha\\v{s}an"
    }, {
      "uri" : "http://drinventor/Wenzel-Jakob",
      "name" : "Wenzel",
      "surname" : "Jakob"
    }, {
      "uri" : "http://drinventor/Jason-Lawrence",
      "name" : "Jason",
      "surname" : "Lawrence"
    }, {
      "uri" : "http://drinventor/Steve-Marschner",
      "name" : "Steve",
      "surname" : "Marschner"
    }, {
      "uri" : "http://drinventor/Ravi-Ramamoorthi",
      "name" : "Ravi",
      "surname" : "Ramamoorthi"
    } ]
  },
  "bagOfWords" : [ "conventional", "brdf", "model", "complex", "microgeometry", "use", "smooth", "normal", "distribution", "function", "-lrb-", "ndf", "-rrb-", "infinitely", "small", "microfacet", "however", "real", "surface", "feature", "certainly", "infinitely", "small", "bump", "flake", "from", "anywhere", "between", "few", "micron", "-lrb-", "brush", "metal", "-rrb-", "about", "0.1", "mm", "-lrb-", "flake", "metallic", "paint", "-rrb-", "centimeter", "-lrb-", "ocean", "wave", "-rrb-", "can", "produce", "interesting", "glinty", "behavior", "visible", "naked", "eye", "glint", "very", "pronounced", "light", "source", "subtend", "small", "solid", "angle", "sun", "small", "light", "fixture", "true", "surface", "specifically", "design", "glint", "metallic", "paint", "embedded", "flake", "decorative", "brush", "metal", "also", "everyday", "object", "plastic", "ceramic", "-lrb-", "see", "Figure", "leave", "-rrb-", "fact", "smooth", "surface", "meet", "microfacet", "assumption", "exception", "rather", "than", "norm", "most", "shiny", "surface", "one", "encounter", "reality", "have", "type", "glinty", "behavior", "readily", "observe", "under", "sharp", "lighting", "we", "goal", "simulate", "glinty", "appearance", "still", "image", "animation", "-lrb-", "see", "Figure", "supplemental", "video", "-rrb-", "represent", "geometry", "resolution", "sufficient", "reveal", "feature", "cause", "glint", "difficult", "we", "use", "high-resolution", "normal", "map", "much", "harder", "challenge", "render", "complex", "specular", "surface", "under", "sharp", "lighting", "Standard", "uniform", "pixel", "sampling", "technique", "direct", "illumination", "have", "extremely", "large", "variance", "use", "they", "purpose", "impractical", "reason", "most", "energy", "concentrate", "tiny", "highlight", "take", "up", "minuscule", "fraction", "pixel", "uniform", "pixel", "sampling", "ineffective", "hit", "highlight", "-lrb-", "figure", "-rrb-", "alternative", "explanation", "space", "valid", "camera-surface-light", "path", "complicate", "can", "easily", "sample", "from", "camera", "from", "light", "some", "sense", "we", "need", "search", "surface", "normal", "align", "half", "vector", "can", "do", "brute-force", "sampling", "normal", "map", "filter", "technique", "-lsb-", "Toksvig", "2005", "Han", "et", "al.", "2007", "Olano", "Baker", "2010", "Dupuy", "et", "al.", "2013", "-rsb-", "also", "do", "fully", "solve", "problem", "method", "attempt", "approximate", "ndf", "naive", "pixel", "sampling", "standard", "approach", "compute", "direct", "illumination", "bumpy", "specular", "surface", "trace", "ray", "through", "pixel", "evaluate", "normal", "hit", "point", "shade", "point", "from", "light", "source", "use", "point?s", "finite", "roughness", "brdf", "fail", "render", "glint", "-lrb-", "figure", "-rrb-", "multiple", "importance", "sampling", "-lsb-", "Veach", "1997", "-rsb-", "do", "help", "because", "pixel", "integral", "inefficiently", "sample", "rather", "than", "brdf/light", "combination", "REYES", "approach", "surface", "subdivision", "micropolygon", "-lsb-", "cook", "et", "al.", "1987", "-rsb-", "equally", "inefficient", "since", "would", "require", "micropolygon", "small", "highlight", "though", "we", "use", "fine", "triangulation", "normal", "map", "smoothness", "we", "method", "can", "handle", "highlight", "arbitrarily", "smaller", "than", "triangle", "normal", "map", "filter", "technique", "can", "deliver", "artifact-free", "rendering", "approximate", "pixel?s", "ndf", "single", "lobe", "-lsb-", "Toksvig", "2005", "Olano", "Baker", "2010", "Dupuy", "et", "al.", "2013", "-rsb-", "small", "number", "lobe", "-lsb-", "Han", "et", "al.", "2007", "-rsb-", "however", "none", "method", "can", "correctly", "capture", "glinty", "appearance", "core", "problem", "true", "ndf", "can", "highly", "complex", "sharp", "feature", "directly", "translate", "spatial", "temporal", "glinting", "approximate", "they", "broad", "lobe", "only", "applicable", "under", "low-frequency", "illumination", "would", "filter", "complex", "feature", "anyway", "Figure", "show", "effect", "replace", "true", "ndf", "single", "gaussian", "mixture", "Gaussians", "thus", "lose", "sharp", "feature", "single-point", "evaluation", "caustic", "caustic", "related", "we", "work", "since", "glint", "can", "interpret", "directional", "caustic", "most", "method", "sample", "path", "-lrb-", "particle", "photon", "-rrb-", "accumulate", "they", "datum", "structure", "-lrb-", "kd-tree", "hash", "grid", "bin", "-rrb-", "however", "sufficient", "we", "purpose", "we", "require", "point", "evaluation", "which", "much", "harder", "Walter", "et", "al.", "-lsb-", "2009", "-rsb-", "compute", "volumetric", "caustic", "due", "refraction", "point", "light", "scattering", "volume", "through", "bumpy", "interface", "related", "we", "approach", "linear", "normal", "interpolation", "over", "triangle", "use", "discrete", "set", "specular", "connection", "enumerate", "Jacobian", "determinant", "term", "determine", "highlight", "intensity", "hierarchy", "use", "speed", "up", "enumeration", "however", "intrinsic", "roughness", "consider", "-lrb-", "result", "singularity", "-rrb-", "phenomenon", "render", "quite", "different", "Mitchell", "Hanrahan", "-lsb-", "1992", "-rsb-", "compute", "reflect", "caustic", "from", "implicit", "surface", "enumerate", "discrete", "set", "valid", "light", "path", "through", "interval", "arithmetic", "use", "wavefront", "trace", "way", "compute", "contribution", "valid", "specular", "path", "again", "we", "method", "-lrb-", "17", "min", "2.2", "min", "actual", "glint", "-rrb-", "naive", "sampling", "-lrb-", "hour", "4,096", "sample", "-rrb-", "correct", "ndf", "isotropic", "gaussian", "-lrb-", "we", "approach", "-rrb-", "-lsb-", "Toksvig", "2005", "-rsb-", "anisotropic", "gaussian", "mixture", "10", "anisotropic", "-lrb-", "lean", "leadr", "-rrb-", "-lsb-", "Han", "et", "al", "2007", "-rsb-", "approximate", "true", "ndf", "single", "gaussian", "-lrb-", "Toksvig", "LEAN", "LEADR", "-rrb-", "small", "number", "Gaussians", "-lrb-", "Han", "et", "al.", "-rrb-", "lose", "sharp", "feature", "cause", "glint", "equivalent", "jacobian", "determinant", "term", "single", "reflection", "associate", "singularity", "other", "work", "specular", "path", "Jakob", "Marschner", "-lsb-", "2012", "-rsb-", "extension", "Metropolis", "light", "transport", "which", "allow", "mutation", "specular", "path", "single", "diffuse", "vertex", "however", "we", "case", "diffuse", "vertex", "available", "mutation", "perfectly", "specular", "case", "discrete", "set", "-lrb-", "rather", "than", "manifold", "-rrb-", "valid", "path", "already", "note", "above", "Moon", "et", "al.", "publish", "several", "approach", "approximate", "higher-order", "specular", "bounce", "e.g.", "-lsb-", "2007", "-rsb-", "loworder", "specular", "path", "still", "compute", "brute-force", "relatively", "large", "light", "source", "stochastic", "reflectance", "-lsb-", "Jakob", "et", "al.", "2014", "-rsb-", "concurrent", "work", "also", "address", "problem", "glinty", "surface", "use", "stochastic", "approach", "rather", "than", "work", "from", "normal", "map", "method", "model", "surface", "procedural", "random", "collection", "specular", "flake", "occur", "accord", "particular", "normal", "distribution", "key", "method", "count", "up", "particle", "contribute", "particular", "illumination", "calculation", "without", "actually", "generate", "they", "provide", "efficiency", "large", "query", "area", "where", "many", "particle", "contribute", "when", "use", "model", "bumpy", "smooth", "surface", "stochastic", "approach", "phenomenological", "random-flake", "approximation", "replace", "p-ndf", "contrast", "we", "algorithm", "exactly", "determine", "how", "give", "specular", "surface", "define", "particular", "normal", "map", "really", "look", "under", "give", "sharp", "illumination", "moreover", "normal", "map", "can", "express", "surface", "feature", "large", "enough", "visible", "image", "e.g.", "scratch", "brush", "example", "paper" ],
  "content" : "Conventional BRDFs model complex microgeometry using a smooth normal distribution function (NDF) of infinitely small microfacets. However, real surface features are certainly not infinitely small. Bumps and flakes from anywhere between a few microns (brushed metal) to about 0.1 mm (flakes in metallic paints) to centimeters (ocean waves) can produce interesting glinty behavior that is visible with the naked eye. These glints are very pronounced with a light source that subtends a small solid angle, such as the sun and small light fixtures. This is true for surfaces specifically designed to glint, such as metallic paints with embedded flakes or decorative brushed metals, but also for everyday objects such as plastics or ceramics (see Figure 2 , left). In fact, smooth surfaces that meet the microfacet assumption are the exception rather than the norm. Most shiny surfaces that one encounters in reality have this type of glinty behavior, readily observed under sharp lighting. Our goal is to simulate glinty appearance in still images and animations (see Figure 1 and the supplemental video). Representing geometry at a resolution sufficient to reveal the features that cause glints is not difficult: we use high-resolution normal maps. A much harder challenge is rendering a complex specular surface under sharp lighting. Standard uniform pixel sampling techniques for direct illumination have extremely large variance, and using them for this purpose is impractical. The reason is that most of the energy is concentrated in tiny highlights that take up a minuscule fraction of a pixel, and uniform pixel sampling is ineffective at hitting the highlights ( Figure 3 ). An alternative explanation is that the space of valid camera-surface-light paths is complicated and cannot be easily sampled from the camera or from the light. In some sense, we need to search the surface for normals aligned with the half vector, and this cannot be done by brute-force sampling. Normal map filtering techniques [Toksvig 2005; Han et al. 2007; Olano and Baker 2010; Dupuy et al. 2013] also do not fully solve the problem. These methods attempt to approximate the NDF at a Naive pixel sampling. The standard approach to compute direct illumination on a bumpy specular surface is to trace a ray through the pixel, evaluate the normal of the hit point, and shade the point from a light source using the point?s finite roughness BRDF; this fails at rendering glints ( Figure 3 ). Multiple importance sampling [Veach 1997] does not help, because it is the pixel integral that is inefficiently sampled, rather than the BRDF/light combination. The REYES approach of surface subdivision into micropolygons [Cook et al. 1987] is equally inefficient, since it would require micropolygons as small as the highlights. Though we use fine triangulations of the normal map for smoothness, our method can handle highlights that are arbitrarily smaller than the triangles. Normal map filtering techniques can deliver artifact-free renderings by approximating a pixel?s NDF by a single lobe [Toksvig 2005; Olano and Baker 2010; Dupuy et al. 2013] or a small number of lobes [Han et al. 2007]. However, none of these methods can correctly capture glinty appearance. The core of the problem is that the true NDFs can be highly complex, and their sharp features directly translate into spatial and temporal glinting. Approximating them by broad lobes is only applicable under low-frequency illumination that would filter the complex features anyway. Figure 4 shows the effect of replacing the true NDF by a single Gaussian or a mixture of Gaussians, thus losing the sharp features. Single-point evaluation of caustics. Caustics are related to our work, since glints can be interpreted as ?directional caustics?. Most methods sample paths (particles, photons) and accumulate them in a data structure (kd-tree, hash grid, or bins). However, this is not sufficient for our purposes; we require point evaluation, which is much harder. Walter et al. [2009] compute volumetric caustics due to the refraction of a point light into a scattering volume through a bumpy interface. This is related to our approach: linear normal interpolation over triangles is used, a discrete set of specular connections is enumerated, the Jacobian determinant term determines highlight intensity, and a hierarchy is used to speed up the enumeration. However, no intrinsic roughness is considered (resulting in singularities), and the phenomenon rendered is quite different. Mitchell and Hanrahan [1992] compute reflected caustics from an implicit surface by enumerating the discrete set of valid light paths through interval arithmetic. They used wavefront tracing as a way to compute the contribution of a valid specular path; this is again Our method (17 min, 2.2 min actual glints) Naive sampling (2 hours, 4,096 samples) correct NDF isotropic Gaussian (our approach) [Toksvig 2005] anisotropic Gaussian mixture of 10 anisotropic (LEAN, LEADR) [Han et al 2007] Approximating the true NDF by a single Gaussian (Toksvig, LEAN, LEADR) or a small number of Gaussians (Han et al.) loses the sharp features that cause glinting. equivalent to the Jacobian determinant term for a single reflection, with the associated singularities. Other work on specular paths. Jakob and Marschner [2012] is an extension of Metropolis light transport, which allows mutation of a specular path at a single diffuse vertex; however, in our case, no diffuse vertex is available for mutations. In the perfectly specular case, there is a discrete set (rather than a manifold) of valid paths, as already noted above. Moon et al. published several approaches to approximate higher-order specular bounces, e.g. [2007], but loworder specular paths are still computed brute-force with a relatively large light source. Stochastic reflectance. [Jakob et al. 2014] is concurrent work that also addresses the problem of glinty surfaces, using a stochastic approach. Rather than work from a normal map, that method models the surface as a procedural random collection of specular flakes that occur according to a particular normal distribution. The key to their method is counting up the particles contributing to a particular illumination calculation without actually generating them, providing efficiency for large query areas where many particles contribute. When used as a model for a bumpy smooth surface, the stochastic approach is phenomenological: the random-flake approximation replaces the P-NDF. In contrast, our algorithm exactly determines how a given specular surface, defined by a particular normal map, really looks under given sharp illumination. Moreover, normal maps can express surface features large enough to be visible in the image, e.g. the scratched and brushed examples in this paper.",
  "resources" : [ ]
}