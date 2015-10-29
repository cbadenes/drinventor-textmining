{
  "uri" : "sig2007-a25-ragan-kelley_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2007/a25-ragan-kelley_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "The Lightspeed Automatic Interactive Lighting Preview System",
    "published" : "2007",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Jonathan-Ragan-Kelley",
      "name" : "Jonathan",
      "surname" : "Ragan-Kelley"
    }, {
      "uri" : "http://drinventor/Charlie-Kilpatrick",
      "name" : "Charlie",
      "surname" : "Kilpatrick"
    }, {
      "uri" : "http://drinventor/Brian W.-Smith",
      "name" : "Brian W.",
      "surname" : "Smith"
    }, {
      "uri" : "http://drinventor/Doug-Epps",
      "name" : "Doug",
      "surname" : "Epps"
    }, {
      "uri" : "http://drinventor/Paul-Green",
      "name" : "Paul",
      "surname" : "Green"
    }, {
      "uri" : "http://drinventor/Christophe-Hery",
      "name" : "Christophe",
      "surname" : "Hery"
    }, {
      "uri" : "http://drinventor/Fr?do-Durand",
      "name" : "Fr?do",
      "surname" : "Durand"
    } ]
  },
  "bagOfWords" : [ "fast", "relighting", "have", "long", "be", "major", "area", "research", "-lsb-", "Dorsey", "et", "al.", "1995", "Ng", "et", "al.", "2003", "-rsb-", "Software", "renderer", "can", "optimize", "repetitive", "re-rendering", "cache", "intermediate", "result", "various", "stage", "render", "process", "pioneer", "TDI", "1980s", "-lsb-", "Alias", "1999", "Pixar", "2001", "Nvidia", "2005", "Tabellion", "Lamorlette", "2004", "-rsb-", "however", "optimization", "must", "integrate", "core", "system", "still", "far", "from", "interactive", "film", "scene", "s?quin", "smyrl", "-lsb-", "1989", "-rsb-", "introduce", "parameterized", "version", "ray", "trace", "enable", "modification", "some", "material", "light", "property", "after", "precomputation", "-lrb-", "although", "light", "direction", "position", "-rrb-", "also", "perform", "cache", "compression", "Gershbein", "Hanrahan", "create", "system", "lighting", "design", "-lsb-", "2000", "-rsb-", "which", "cache", "intermediate", "result", "deep-framebuffer", "inspire", "G-Buffers", "-lsb-", "Saito", "Takahashi", "1990", "-rsb-", "cache", "fix", "set", "datum", "approximate", "shade", "multitexturing", "Pellacini", "et", "al.", "perform", "shade", "programmable", "graphic", "hardware", "-lsb-", "2005", "-rsb-", "use", "manually-written", "shader", "emulate", "RenderMan", "shader", "system", "require", "manual", "segmentation", "shader", "light-dependent", "light-independent", "component", "manual", "translation", "preview", "shader", "while", "allow", "manual", "optimization", "maximize", "preview", "performance", "significant", "burden", "we", "choose", "potentially", "sacrifice", "performance", "tremendously", "improve", "integration", "maintainability", "automate", "segmentation", "translation", "shader", "furthermore", "we", "extend", "prior", "deep-framebuffer", "system", "enable", "efficient", "rendering", "transparent", "surface", "multisampling", "effect", "motion", "blur", "finally", "we", "approach", "also", "automatically", "support", "editing", "many", "-lrb-", "user-selected", "-rrb-", "surface", "property", "because", "employ", "data-flow", "analysis", "respect", "arbitrary", "parameter", "Wexler", "et", "al.", "implement", "high-quality", "supersampling", "GPU", "-lsb-", "2005", "-rsb-", "focus", "final", "rendering", "while", "we", "optimize", "static", "visibility", "result", "different", "datum", "structure", "we", "build", "recent", "work", "direct-to-indirect", "transfer", "which", "exploit", "linearity", "global", "illumination", "cinematic", "relighting", "-lsb-", "ha", "san", "et", "al.", "2006", "-rsb-", "we", "apply", "similar", "principle", "multisampling", "transparency", "subsurface", "scattering", "Jones", "et", "al.", "segmented", "shader", "static", "dynamic", "subset", "cache", "shade", "information", "texture-space", "accelerate", "render", "same", "scene", "multiple", "time", "under", "similar", "configuration", "-lsb-", "2000", "-rsb-", "however", "technique", "only", "cache", "shade", "computation?not", "tessellation", "displacement", "etc.", "require", "manual", "shader", "segmentation", "we", "goal", "can", "fully", "meet", "pre-computed", "radiance", "transfer", "-lrb-", "prt", "-rrb-", "technique", "-lsb-", "Sloan", "et", "al.", "2002", "Ng", "et", "al.", "2003", "-rsb-", "because", "usually", "make", "assumption", "reflectance", "lighting", "have", "significant", "precomputation", "cost", "contrast", "we", "need", "handle", "effect", "local", "point", "light", "source", "arbitrary", "reflectance", "furthermore", "compute", "illumination", "itself", "large", "part", "we", "run-time", "calculation", "production", "light", "shader", "quite", "complex", "compiler", "specialization", "graphic", "computation", "first", "use", "ray", "trace", "-lsb-", "Hanrahan", "1983", "Mogensen", "1986", "Andersen", "1996", "-rsb-", "Guenter", "Knoblock", "Ruf", "develop", "datum", "specialization", "reduce", "cost", "recomputation", "when", "only", "certain", "shade", "parameter", "vary", "automatically", "segment", "shader", "parameterdependent", "independent", "component", "-lsb-", "1995", "1996", "-rsb-", "we", "leverage", "approach", "context", "lighting", "design", "extend", "analysis", "global", "data-flow", "through", "exist", "real-world", "RenderMan", "shader", "we", "solve", "specialization", "use", "graph", "formulation", "mention", "implement", "Knoblock", "Ruf", "-lsb-", "1996", "-rsb-", "allow", "we", "only", "specialize", "respect", "dynamic", "parameter", "also", "perform", "dead-code", "elimination", "other", "analysis", "all", "from", "single", "dependence", "analysis", "Peercy", "et", "al.", "-lsb-", "2000", "-rsb-", "bleiweiss", "preetham", "-lsb-", "2003", "-rsb-", "address", "compilation", "RenderMan", "shader", "onto", "graphic", "hardware", "we", "too", "exploit", "fact", "large", "subset", "RenderMan", "Shading", "language", "-lrb-", "rsl", "-rrb-", "can", "compile", "GPU", "we", "interest", "however", "use", "RSL", "GPU", "shade", "language", "automatically", "specialize", "final-frame", "shader", "create", "appropriate", "deep", "framebuffer", "interactive", "relighting", "configure", "light", "critical", "bottleneck", "modern", "production", "rendering", "recent", "advance", "have", "seek", "provide", "real-time", "preview", "use", "deep-framebuffer", "graphic", "hardware", "-lsb-", "gershbein", "Hanrahan", "2000", "Pellacini", "et", "al.", "2005", "-rsb-", "deep-framebuffer", "cache", "static", "value", "normal", "texture", "sample", "image", "space", "each", "time", "user", "update", "light", "parameter", "realtime", "shader", "interactively", "recompute", "image", "from", "cache", "unfortunately", "approach", "require", "substantial", "additional", "work", "from", "shader", "author", "example", "lpic", "system", "deploy", "Pixar", "-lsb-", "Pellacini", "et", "al.", "2005", "-rsb-", "least", "two", "version", "each", "shader", "need", "write", "place", "just", "one", "usual", "RenderMan", "shader", "use", "final", "rendering", "-lrb-", "additional", "code", "path", "cache", "datum", "-rrb-", "cg", "version", "use", "real-time", "preview", "we", "alleviate", "need", "author", "multiple", "version", "shader", "automatically", "translate", "unmodified", "RenderMan", "shader", "realtime", "shader", "precomputation", "shader", "translation", "part", "larger", "process", "automatically", "generate", "deep-framebuffer", "datum", "from", "unmodified", "exist", "scene", "theory", "some", "RenderMan", "code", "can", "translate", "GPU", "shader", "we", "have", "find", "practice", "dynamic", "part", "we", "production", "shader", "translate", "well", "contrast", "pure", "static", "compiler", "analysis", "we", "use", "postexecution", "cache", "compression", "supplement", "simple", "compiler", "analysis", "cache", "compression", "effectively", "reduce", "automaticallygenerated", "deep-framebuffer", "reasonable", "size", "complex", "production", "shader", "addition", "transparency", "motion", "blur", "antialiasing", "can", "critical", "judge", "appearance", "we", "introduce", "indirect", "framebuffer", "which", "enable", "effect", "without", "linearly", "scale", "render", "time", "similar", "RenderMan", "decouple", "shade", "from", "visibility", "also", "precompute", "final", "weight", "each", "shade", "sample", "relevant", "final", "pixel", "give", "complexity", "shot", "we", "handle", "we", "also", "use", "progressive", "refinement", "offer", "both", "interactive", "feedback", "-lrb-", "multiple", "frame", "per", "second", "-rrb-", "faithful", "final", "quality", "-lrb-", "potentially", "after", "few", "seconds", "-rrb-", "finally", "important", "facilitate", "implementation", "new", "pass", "preview", "system", "we", "use", "computation", "graph", "directly", "express", "dependency", "data-flow", "between", "pass", "implement", "shadow", "translucency", "we", "describe", "full", "production", "relighting", "system", "be", "deploy", "two", "studio", "different", "render", "workflow", "fast", "relighting", "have", "long", "be", "major", "area", "research", "-lsb-", "Dorsey", "et", "al.", "1995", "Ng", "et", "al.", "2003", "-rsb-", "Software", "renderer", "can", "optimize", "repetitive", "re-rendering", "cache", "intermediate", "result", "various", "stage", "render", "process", "pioneer", "TDI", "1980s", "-lsb-", "Alias", "1999", "Pixar", "2001", "Nvidia", "2005", "Tabellion", "Lamorlette", "2004", "-rsb-", "however", "optimization", "must", "integrate", "core", "system", "still", "far", "from", "interactive", "film", "scene", "s?quin", "smyrl", "-lsb-", "1989", "-rsb-", "introduce", "parameterized", "version", "ray", "trace", "enable", "modification", "some", "material", "light", "property", "after", "precomputation", "-lrb-", "although", "light", "direction", "position", "-rrb-", "also", "perform", "cache", "compression", "Gershbein", "Hanrahan", "create", "system", "lighting", "design", "-lsb-", "2000", "-rsb-", "which", "cache", "intermediate", "result", "deep-framebuffer", "inspire", "G-Buffers", "-lsb-", "Saito", "Takahashi", "1990", "-rsb-", "cache", "fix", "set", "datum", "approximate", "shade", "multitexturing", "Pellacini", "et", "al.", "perform", "shade", "programmable", "graphic", "hardware", "-lsb-", "2005", "-rsb-", "use", "manually-written", "shader", "emulate", "RenderMan", "shader", "system", "require", "manual", "segmentation", "shader", "light-dependent", "light-independent", "component", "manual", "translation", "preview", "shader", "while", "allow", "manual", "optimization", "maximize", "preview", "performance", "significant", "burden", "we", "choose", "potentially", "sacrifice", "performance", "tremendously", "improve", "integration", "maintainability", "automate", "segmentation", "translation", "shader", "furthermore", "we", "extend", "prior", "deep-framebuffer", "system", "enable", "efficient", "rendering", "transparent", "surface", "multisampling", "effect", "motion", "blur", "finally", "we", "approach", "also", "automatically", "support", "editing", "many", "-lrb-", "user-selected", "-rrb-", "surface", "property", "because", "employ", "data-flow", "analysis", "respect", "arbitrary", "parameter", "Wexler", "et", "al.", "implement", "high-quality", "supersampling", "GPU", "-lsb-", "2005", "-rsb-", "focus", "final", "rendering", "while", "we", "optimize", "static", "visibility", "result", "different", "datum", "structure", "we", "build", "recent", "work", "direct-to-indirect", "transfer", "which", "exploit", "linearity", "global", "illumination", "cinematic", "relighting", "-lsb-", "ha", "san", "et", "al.", "2006", "-rsb-", "we", "apply", "similar", "principle", "multisampling", "transparency", "subsurface", "scattering", "Jones", "et", "al.", "segmented", "shader", "static", "dynamic", "subset", "cache", "shade", "information", "texture-space", "accelerate", "render", "same", "scene", "multiple", "time", "under", "similar", "configuration", "-lsb-", "2000", "-rsb-", "however", "technique", "only", "cache", "shade", "computation?not", "tessellation", "displacement", "etc.", "require", "manual", "shader", "segmentation", "we", "goal", "can", "fully", "meet", "pre-computed", "radiance", "transfer", "-lrb-", "prt", "-rrb-", "technique", "-lsb-", "Sloan", "et", "al.", "2002", "Ng", "et", "al.", "2003", "-rsb-", "because", "usually", "make", "assumption", "reflectance", "lighting", "have", "significant", "precomputation", "cost", "contrast", "we", "need", "handle", "effect", "local", "point", "light", "source", "arbitrary", "reflectance", "furthermore", "compute", "illumination", "itself", "large", "part", "we", "run-time", "calculation", "production", "light", "shader", "quite", "complex", "compiler", "specialization", "graphic", "computation", "first", "use", "ray", "trace", "-lsb-", "Hanrahan", "1983", "Mogensen", "1986", "Andersen", "1996", "-rsb-", "Guenter", "Knoblock", "Ruf", "develop", "datum", "specialization", "reduce", "cost", "recomputation", "when", "only", "certain", "shade", "parameter", "vary", "automatically", "segment", "shader", "parameterdependent", "independent", "component", "-lsb-", "1995", "1996", "-rsb-", "we", "leverage", "approach", "context", "lighting", "design", "extend", "analysis", "global", "data-flow", "through", "exist", "real-world", "RenderMan", "shader", "we", "solve", "specialization", "use", "graph", "formulation", "mention", "implement", "Knoblock", "Ruf", "-lsb-", "1996", "-rsb-", "allow", "we", "only", "specialize", "respect", "dynamic", "parameter", "also", "perform", "dead-code", "elimination", "other", "analysis", "all", "from", "single", "dependence", "analysis", "Peercy", "et", "al.", "-lsb-", "2000", "-rsb-", "bleiweiss", "preetham", "-lsb-", "2003", "-rsb-", "address", "compilation", "RenderMan", "shader", "onto", "graphic", "hardware", "we", "too", "exploit", "fact", "large", "subset", "RenderMan", "Shading", "language", "-lrb-", "rsl", "-rrb-", "can", "compile", "GPU", "we", "interest", "however", "use", "RSL", "GPU", "shade", "language", "automatically", "specialize", "final-frame", "shader", "create", "appropriate", "deep", "framebuffer", "interactive", "relighting", "configure", "light", "critical", "bottleneck", "modern", "production", "rendering", "recent", "advance", "have", "seek", "provide", "real-time", "preview", "use", "deep-framebuffer", "graphic", "hardware", "-lsb-", "gershbein", "Hanrahan", "2000", "Pellacini", "et", "al.", "2005", "-rsb-", "deep-framebuffer", "cache", "static", "value", "normal", "texture", "sample", "image", "space", "each", "time", "user", "update", "light", "parameter", "realtime", "shader", "interactively", "recompute", "image", "from", "cache", "unfortunately", "approach", "require", "substantial", "additional", "work", "from", "shader", "author", "example", "lpic", "system", "deploy", "Pixar", "-lsb-", "Pellacini", "et", "al.", "2005", "-rsb-", "least", "two", "version", "each", "shader", "need", "write", "place", "just", "one", "usual", "RenderMan", "shader", "use", "final", "rendering", "-lrb-", "additional", "code", "path", "cache", "datum", "-rrb-", "cg", "version", "use", "real-time", "preview", "we", "alleviate", "need", "author", "multiple", "version", "shader", "automatically", "translate", "unmodified", "RenderMan", "shader", "realtime", "shader", "precomputation", "shader", "translation", "part", "larger", "process", "automatically", "generate", "deep-framebuffer", "datum", "from", "unmodified", "exist", "scene", "theory", "some", "RenderMan", "code", "can", "translate", "GPU", "shader", "we", "have", "find", "practice", "dynamic", "part", "we", "production", "shader", "translate", "well", "contrast", "pure", "static", "compiler", "analysis", "we", "use", "postexecution", "cache", "compression", "supplement", "simple", "compiler", "analysis", "cache", "compression", "effectively", "reduce", "automaticallygenerated", "deep-framebuffer", "reasonable", "size", "complex", "production", "shader", "addition", "transparency", "motion", "blur", "antialiasing", "can", "critical", "judge", "appearance", "we", "introduce", "indirect", "framebuffer", "which", "enable", "effect", "without", "linearly", "scale", "render", "time", "similar", "RenderMan", "decouple", "shade", "from", "visibility", "also", "precompute", "final", "weight", "each", "shade", "sample", "relevant", "final", "pixel", "give", "complexity", "shot", "we", "handle", "we", "also", "use", "progressive", "refinement", "offer", "both", "interactive", "feedback", "-lrb-", "multiple", "frame", "per", "second", "-rrb-", "faithful", "final", "quality", "-lrb-", "potentially", "after", "few", "seconds", "-rrb-", "finally", "important", "facilitate", "implementation", "new", "pass", "preview", "system", "we", "use", "computation", "graph", "directly", "express", "dependency", "data-flow", "between", "pass", "implement", "shadow", "translucency", "we", "describe", "full", "production", "relighting", "system", "be", "deploy", "two", "studio", "different", "render", "workflow" ],
  "content" : "Fast relighting has long been a major area of research [Dorsey et al. 1995; Ng et al. 2003]. Software renderers can be optimized for repetitive re-rendering by caching intermediate results at various stages of the rendering process as pioneered by TDI in the 1980s [Alias 1999; Pixar 2001; Nvidia 2005; Tabellion and Lamorlette 2004]. However, such optimizations must be integrated at the core of a system and are still far from interactive for film scenes. S?quin and Smyrl [1989] introduced a parameterized version of ray tracing that enables the modification of some material and light properties after precomputation (although not the light direction or position). They also perform cache compression. Gershbein and Hanrahan created a system for lighting design [2000] which cached intermediate results in a deep-framebuffer inspired by G-Buffers [Saito and Takahashi 1990]. They cached a fixed set of data, and approximated shading with multitexturing. Pellacini et al. performed shading on programmable graphics hardware [2005] using manually-written shaders that emulate RenderMan shaders. These systems require manual segmentation of shaders into light-dependent and light-independent components, and manual translation of preview shaders. While this allows for manual optimization to maximize preview performance, it is a significant burden. We chose to potentially sacrifice performance but tremendously improve integration and maintainability by automating the segmentation and translation of shaders. Furthermore, we extend prior deep-framebuffer systems by enabling the efficient rendering of transparent surfaces and multisampling effects, such as motion blur. Finally, our approach also automatically supports editing many (user-selected) surface properties because it employs data-flow analysis with respect to arbitrary parameters. Wexler, et al. implemented high-quality supersampling on the GPU [2005], but they focus on final rendering, while we optimize for static visibility, resulting in a different data structure. We build on recent work on direct-to-indirect transfer, which exploits linearity for global illumination in cinematic relighting [Ha san et al. 2006]. We apply similar principles to multisampling, transparency and subsurface scattering. Jones et al. segmented shaders into static and dynamic subsets and cached shading information in texture-space to accelerate rendering the same scene multiple times under similar configurations [2000]. However, their technique only cached shading computation?not tessellation, displacement, etc.?and required manual shader segmentation. Our goals cannot be fully met by pre-computed radiance transfer (PRT) techniques [Sloan et al. 2002; Ng et al. 2003], because they usually make assumptions on the reflectance or lighting and have significant precomputation cost. In contrast, we need to handle the effect of local point light sources and arbitrary reflectance. Furthermore, computing illumination itself is a large part of our run-time calculation as production light shaders are quite complex. Compiler specialization of graphics computation was first used for ray tracing [Hanrahan 1983; Mogensen 1986; Andersen 1996]. Guenter, Knoblock & Ruf developed data specialization to reduce the cost of recomputation when only certain shading parameters vary, by automatically segmenting shaders into parameterdependent and -independent components [1995; 1996]. We leverage their approach in the context of lighting design and extend their analyses to global data-flow through existing real-world RenderMan shaders. We solve specialization using a graph formulation, mentioned but not implemented by Knoblock and Ruf [1996]. This allows us to not only specialize with respect to dynamic parameters, but also to perform dead-code elimination and other analyses, all from a single dependence analysis. Peercy et al. [2000] and Bleiweiss and Preetham [2003] addressed the compilation of RenderMan shaders onto graphics hardware. We, too, exploit the fact that a large subset of the RenderMan Shading Language (RSL) can be compiled to a GPU. Our interest, however, is not in using RSL as a GPU shading language, but in automatically specializing final-frame shaders and creating an appropriate deep framebuffer for interactive relighting. Configuring lights is a critical bottleneck in modern production rendering, and recent advances have sought to provide real-time preview using deep-framebuffers and graphics hardware [Gershbein and Hanrahan 2000; Pellacini et al. 2005]. A deep-framebuffer caches static values such as normals and texture samples in image space, and each time the user updates light parameters, realtime shaders interactively recompute the image from the cache. Unfortunately, these approaches require substantial additional work from shader authors. For example, in the lpics system deployed at Pixar [Pellacini et al. 2005], at least two versions of each shader need to be written in place of just one: the usual RenderMan shader used for the final rendering (with additional code paths to cache data), and a Cg version used for real-time preview. We alleviate the need to author multiple versions of a shader by automatically translating unmodified RenderMan shaders into realtime shaders and precomputation shaders. This translation is part of a larger process that automatically generates deep-framebuffer data from unmodified existing scenes. In theory, some RenderMan code cannot be translated into GPU shaders, but we have found that, in practice, the dynamic parts of our production shaders translate well. In contrast to pure static compiler analysis, we use postexecution cache compression to supplement a simple compiler analysis. Cache compression effectively reduces automaticallygenerated deep-framebuffers to reasonable size for complex production shaders. In addition, transparency, motion blur and antialiasing can be critical to judge appearance. We introduce the indirect framebuffer, which enables these effects without linearly scaling rendering time. Similar to RenderMan, it decouples shading from visibility, but also precomputes the final weight of each shading sample for the relevant final pixels. Given the complexity of shots that we handle, we also use progressive refinement to offer both interactive feedback (multiple frames per second) and faithful final quality (potentially after a few seconds). Finally, it is important to facilitate the implementation of new passes in a preview system. We use a computation graph that directly expresses the dependencies and data-flow between passes to implement shadows and translucency. We describe a full production relighting system that is being deployed in two studios with different rendering workflows. Fast relighting has long been a major area of research [Dorsey et al. 1995; Ng et al. 2003]. Software renderers can be optimized for repetitive re-rendering by caching intermediate results at various stages of the rendering process as pioneered by TDI in the 1980s [Alias 1999; Pixar 2001; Nvidia 2005; Tabellion and Lamorlette 2004]. However, such optimizations must be integrated at the core of a system and are still far from interactive for film scenes. S?quin and Smyrl [1989] introduced a parameterized version of ray tracing that enables the modification of some material and light properties after precomputation (although not the light direction or position). They also perform cache compression. Gershbein and Hanrahan created a system for lighting design [2000] which cached intermediate results in a deep-framebuffer inspired by G-Buffers [Saito and Takahashi 1990]. They cached a fixed set of data, and approximated shading with multitexturing. Pellacini et al. performed shading on programmable graphics hardware [2005] using manually-written shaders that emulate RenderMan shaders. These systems require manual segmentation of shaders into light-dependent and light-independent components, and manual translation of preview shaders. While this allows for manual optimization to maximize preview performance, it is a significant burden. We chose to potentially sacrifice performance but tremendously improve integration and maintainability by automating the segmentation and translation of shaders. Furthermore, we extend prior deep-framebuffer systems by enabling the efficient rendering of transparent surfaces and multisampling effects, such as motion blur. Finally, our approach also automatically supports editing many (user-selected) surface properties because it employs data-flow analysis with respect to arbitrary parameters. Wexler, et al. implemented high-quality supersampling on the GPU [2005], but they focus on final rendering, while we optimize for static visibility, resulting in a different data structure. We build on recent work on direct-to-indirect transfer, which exploits linearity for global illumination in cinematic relighting [Ha san et al. 2006]. We apply similar principles to multisampling, transparency and subsurface scattering. Jones et al. segmented shaders into static and dynamic subsets and cached shading information in texture-space to accelerate rendering the same scene multiple times under similar configurations [2000]. However, their technique only cached shading computation?not tessellation, displacement, etc.?and required manual shader segmentation. Our goals cannot be fully met by pre-computed radiance transfer (PRT) techniques [Sloan et al. 2002; Ng et al. 2003], because they usually make assumptions on the reflectance or lighting and have significant precomputation cost. In contrast, we need to handle the effect of local point light sources and arbitrary reflectance. Furthermore, computing illumination itself is a large part of our run-time calculation as production light shaders are quite complex. Compiler specialization of graphics computation was first used for ray tracing [Hanrahan 1983; Mogensen 1986; Andersen 1996]. Guenter, Knoblock & Ruf developed data specialization to reduce the cost of recomputation when only certain shading parameters vary, by automatically segmenting shaders into parameterdependent and -independent components [1995; 1996]. We leverage their approach in the context of lighting design and extend their analyses to global data-flow through existing real-world RenderMan shaders. We solve specialization using a graph formulation, mentioned but not implemented by Knoblock and Ruf [1996]. This allows us to not only specialize with respect to dynamic parameters, but also to perform dead-code elimination and other analyses, all from a single dependence analysis. Peercy et al. [2000] and Bleiweiss and Preetham [2003] addressed the compilation of RenderMan shaders onto graphics hardware. We, too, exploit the fact that a large subset of the RenderMan Shading Language (RSL) can be compiled to a GPU. Our interest, however, is not in using RSL as a GPU shading language, but in automatically specializing final-frame shaders and creating an appropriate deep framebuffer for interactive relighting. Configuring lights is a critical bottleneck in modern production rendering, and recent advances have sought to provide real-time preview using deep-framebuffers and graphics hardware [Gershbein and Hanrahan 2000; Pellacini et al. 2005]. A deep-framebuffer caches static values such as normals and texture samples in image space, and each time the user updates light parameters, realtime shaders interactively recompute the image from the cache. Unfortunately, these approaches require substantial additional work from shader authors. For example, in the lpics system deployed at Pixar [Pellacini et al. 2005], at least two versions of each shader need to be written in place of just one: the usual RenderMan shader used for the final rendering (with additional code paths to cache data), and a Cg version used for real-time preview. We alleviate the need to author multiple versions of a shader by automatically translating unmodified RenderMan shaders into realtime shaders and precomputation shaders. This translation is part of a larger process that automatically generates deep-framebuffer data from unmodified existing scenes. In theory, some RenderMan code cannot be translated into GPU shaders, but we have found that, in practice, the dynamic parts of our production shaders translate well. In contrast to pure static compiler analysis, we use postexecution cache compression to supplement a simple compiler analysis. Cache compression effectively reduces automaticallygenerated deep-framebuffers to reasonable size for complex production shaders. In addition, transparency, motion blur and antialiasing can be critical to judge appearance. We introduce the indirect framebuffer, which enables these effects without linearly scaling rendering time. Similar to RenderMan, it decouples shading from visibility, but also precomputes the final weight of each shading sample for the relevant final pixels. Given the complexity of shots that we handle, we also use progressive refinement to offer both interactive feedback (multiple frames per second) and faithful final quality (potentially after a few seconds). Finally, it is important to facilitate the implementation of new passes in a preview system. We use a computation graph that directly expresses the dependencies and data-flow between passes to implement shadows and translucency. We describe a full production relighting system that is being deployed in two studios with different rendering workflows.",
  "resources" : [ ]
}